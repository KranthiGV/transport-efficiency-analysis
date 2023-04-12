import argparse
import os
from pathlib import Path
import requests
from tqdm import tqdm
from bs4 import BeautifulSoup
import zipfile

def download_file(url, output_dir, simulate=False):
    response = requests.get(url, stream=True)
    file_size = int(response.headers.get("content-length", 0))
    filename = os.path.join(output_dir, url.split("/")[-1])

    if simulate:
        print(f"Simulated download of {filename} ({file_size / (1024 * 1024):.2f} MB)")
        return

    with open(filename, "wb") as f:
        with tqdm(
            total=file_size, unit="iB", unit_scale=True, desc=filename.split("/")[-1]
        ) as pbar:
            for data in response.iter_content(chunk_size=1024):
                f.write(data)
                pbar.update(len(data))

    return filename

def parse_datasets(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.text, "html.parser")
    dataset_links = []

    for link in soup.find_all("a"):
        href = link.get("href")
        if "citibike-tripdata" in href and ".zip" in href and "JC-" not in href:
            dataset_links.append(href)

    return dataset_links

def unzip_file(file_path, output_dir):
    with zipfile.ZipFile(file_path, "r") as zip_ref:
        zip_ref.extractall(output_dir)

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description="Download and unzip datasets from a given URL")
    parser.add_argument("--url", default="https://s3.amazonaws.com/tripdata/index.html", help="URL to download datasets from")
    parser.add_argument("--output-dir", default=Path("."), help="Output directory for downloaded datasets")
    parser.add_argument("--simulate", action="store_true", help="Simulate download instead of actually downloading")
    parser.add_argument("--unzip", action="store_true", help="Unzip the downloaded datasets")

    args = parser.parse_args()

    dataset_links = parse_datasets(args.url)

    for dataset_url in dataset_links:
        downloaded_file = download_file(dataset_url, args.output_dir, args.simulate)
        if args.unzip and not args.simulate:
            unzip_file(downloaded_file, args.output_dir)
