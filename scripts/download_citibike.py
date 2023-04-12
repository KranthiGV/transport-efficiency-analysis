import argparse
import os
import re
import zipfile
from urllib.request import urlretrieve

from bs4 import BeautifulSoup
from tqdm import tqdm


class TqdmUpTo(tqdm):
    def update_to(self, b=1, bsize=1, tsize=None):
        if tsize is not None:
            self.total = tsize
        self.update(b * bsize - self.n)


def download_zip(url, output_dir, simulate):
    file_name = url.split('/')[-1]
    output_file = os.path.join(output_dir, file_name)

    if simulate:
        print(f'Simulating download: {url} -> {output_file}')
        return output_file

    with TqdmUpTo(unit='B', unit_scale=True, miniters=1, desc=file_name) as t:
        urlretrieve(url, filename=output_file, reporthook=t.update_to)

    return output_file


def unzip_file(file_path, output_dir, simulate):
    if simulate:
        print(f'Simulating unzip: {file_path}')
        return

    with zipfile.ZipFile(file_path, 'r') as zip_ref:
        zip_ref.extractall(output_dir)


def main(input_html_file, output_dir, simulate, unzip):
    with open(input_html_file, 'r') as f:
        html_content = f.read()

    soup = BeautifulSoup(html_content, 'html.parser')
    links = soup.find_all('a', href=True)

    csv_zip_links = [link['href'] for link in links if link['href'].endswith('.csv.zip') and not link['href'].startswith('https://s3.amazonaws.com/tripdata/JC-')]

    os.makedirs(output_dir, exist_ok=True)

    for url in csv_zip_links:
        downloaded_file = download_zip(url, output_dir, simulate)
        if unzip:
            unzip_file(downloaded_file, output_dir, simulate)


if __name__ == '__main__':
    parser = argparse.ArgumentParser(description='Download and unzip Citibike trip data.')
    parser.add_argument('input_html_file', help='Input HTML file with links to the zip files.')
    parser.add_argument('output_dir', help='Directory to store the downloaded and unzipped files.')
    parser.add_argument('--simulate', action='store_true', help='Simulate the download and unzip process without actually downloading and unzipping the files.')
    parser.add_argument('--unzip', action='store_true', help='Unzip the downloaded files.')

    args = parser.parse_args()

    main(args.input_html_file, args.output_dir, args.simulate, args.unzip)
