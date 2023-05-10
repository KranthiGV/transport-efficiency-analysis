# Transportation Efficiency Analysis in New York City using Citibike data

This project aims to analyze transportation efficiency in New York City using data from the Citibike bike-sharing system. It provides Java-based code to process Citibike data and SQL queries to perform analysis, along with scripts to clean, download, and merge datasets.

## Project Structure
```
.
├── .gitignore
├── LICENSE
├── README.md
├── citibike
│   ├── CitibikeCounter.java
│   ├── CitibikeDriver.java
│   ├── CitibikeMapper.java
│   ├── CitibikeQueries.sql
│   ├── CitibikeUtils.java
│   └── Makefile
├── notes
│   ├── citibike.md
│   └── citibike_analysis.md
└── scripts
    └── citibike
        ├── clean_datadir.sh
        ├── dataexploration.ipynb
        ├── download.py
        └── merge_datasets.ipynb
```
## Files and Directories Overview

### citibike
- `CitibikeCounter.java`: Java code for Citibike counting operations.
- `CitibikeDriver.java`: Java driver code to execute Citibike MapReduce code.
- `CitibikeMapper.java`: Java code for Citibike MapReduce operations.
- `CitibikeQueries.sql`: Trino queries to perform analysis on the processed Citibike data.
- `CitibikeUtils.java`: Utility class for Citibike-related operations.
- `Makefile`: Makefile for building and running the Java project.

### notes
- `citibike.md`: Notes about the Citibike dataset and its attributes. Used during preprocessing.
- `citibike_analysis.md`: Notes on the analysis of the Citibike data.

### scripts/citibike
- `clean_datadir.sh`: Shell script to clean the data directory.
- `dataexploration.ipynb`: Jupyter Notebook for exploratory data analysis.
- `download.py`: Python script to download the Citibike datasets.
- `merge_datasets.ipynb`: Jupyter Notebook to merge multiple Citibike datasets.

## Getting Started

1. Run the `scripts/citibike/download.py` script to download the Citibike datasets.
2. Use the `scripts/citibike/merge_datasets.ipynb` notebook to merge downloaded datasets.
3. Run `make` in the `citibike` directory to build and execute the MapReduce project.
4. Analyze the Citibike data using `citibike/CitibikeQueries.sql`.
