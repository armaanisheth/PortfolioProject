# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Calendar Versioning](https://calver.org/) of
the following form: YYYY.0M.0D.


## [2026.02.06]

### Added

- Designed a Book Inventory component
- Designed a Music Playlist component
- Designed a Data Table for Integers component

## [2026.02.26]

### Added

- Designed a proof of concept for Music Playlist component

### Updated

- Changed design to include initial kernel methods (add, remove, length), map representation
- Tested a mock example of a main method with potential songs and artists with kernel method manipulations

## [2026.03.09]

### Added

- Designed kernel and enhanced interfaces for MusicPlaylist component

### Updated

- Changed design to include method contracts for kernel and secondary methods
- Changed original proof-of-concept to a new potential implementation with the inclusion of a secondary method
- Settings is changed, library is accessible to all users instead a direct path

## [2026.04.01]

### Added

- Designed abstract class for MusicPlaylistSecondary component
- Designed secondary methods based on kernels
- Specific toString and equals methods necessary for proper implementation
- Remove any, new instance, and transferfrom method to original kernel

### Updated

- Changed secondary method implementation to exclude peeking method for now, this creates
a problem due to the lack order and general map structure

## [2026.04.15]

### Added

- Designed kernel implementations to extend MusicPlaylistSecondary component
- Kernels included add, remove, length (add a new song, remove a song, or check the playlist length)
- Wrote the correspondance and convention

### Updated

- Changed the implementations of the kernel from the original design to make more sense for adding and removing from a playlist.

## [2026.04.23]

### Added

- Designed several test cases in two JUnit files.
- Added two use cases.

### Updated

- Changed the implementations of the kernel, secondary, and interfaces to match each other and be more efficient.
- General organization and merged into one available spot for all material.
