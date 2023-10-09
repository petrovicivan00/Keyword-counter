# Keyword Counter

## Table of Contents

- [Description](#description)
- [System Overview](#system-overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Configuration](#configuration)
- [Usage](#usage)
  - [Adding Directories and Websites](#adding-directories-and-websites)
  - [Querying and Retrieving Results](#querying-and-retrieving-results)
- [Examples](#examples)
- [Contributing](#contributing)
- [License](#license)

## Description

Keyword Counter is a system designed to count the occurrences of predefined keywords in various corpora. It supports concurrent counting, allows adding new corpora, and provides a way to review and summarize the counting results for individual corpora. This system works with both ASCII-encoded text files and HTML files available on the web. Keywords are counted only when they appear as standalone words, not as part of other words, and the search is case-sensitive.

## System Overview

The system is comprised of three components based on thread pools: Web Scanner, File Scanner, and Result Retriever. Additionally, several auxiliary components run in their own threads:

- Main / CLI: The user interacts with the system through the command line.
- Job Dispatcher: Manages job distribution to the appropriate thread pool.
- Directory Crawler: Scans directories for text corpora.
- Result Retriever: Stores and retrieves counting results.

### Configuration

The system can be configured using the `app.properties` file. Here are the configurable parameters:

- `keywords`: A comma-separated list of keywords to be counted in corpora.
- `file_corpus_prefix`: Prefix for directories containing text corpora.
- `dir_crawler_sleep_time`: Sleep time for the directory crawler in milliseconds.
- `file_scanning_size_limit`: Size limit in bytes for the file scanner component.
- `hop_count`: The number of jumps to make during web scanning.
- `url_refresh_time`: Time in milliseconds after which visited URLs are cleared.

Please note that these parameters are read once at system startup and cannot be changed during runtime.

## Usage

### Adding Directories and Websites

- `ad <directory>`: Add a directory for scanning.
- `aw <URL>`: Add a website to start a web scan.

### Querying and Retrieving Results

- `get <query>`: Retrieve results from the Result Retriever component (blocking).
- `query <query>`: Query results from the Result Retriever component (non-blocking).
- `cws` / `cfs`: Clear web summary / Clear file summary.

## Examples

### Adding a directory and retrieving results:

```shell
ad data
get file|corpus_a
```

### Adding a website, querying a web summary, and retrieving results:

```shell
aw https://www.gatesnotes.com/2019-Annual-Letter
query web|summary
get web|summary
```

## Contributing

Contributions to this project are welcome. Please refer to the [Contributing Guidelines](CONTRIBUTING.md) for details.

## License

This project is licensed under the [MIT License](LICENSE).

Feel free to modify this template to fit your project's specific needs and structure. Don't forget to create the corresponding files, such as `CONTRIBUTING.md` and `LICENSE`.
