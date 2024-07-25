# <img src="src/main/resources/icon.png" alt="App Icon" style="width:32px;"> rkg-tool

GUI tool for Mario Kart Wii [ghost](https://wiki.tockdom.com/wiki/RKG_(File_Format)) and [save](https://wiki.tockdom.com/wiki/RKSYS) data files.

<img src="images/baseframe.png" alt="Base Frame" style="width:750">

## Building from Source

### Instructions

1) Install [Apache Maven](https://maven.apache.org/).
2) Clone this repository.
3) Run `mvn package`. The output jar file and [launch4j](https://launch4j.sourceforge.net) executable will be in /target.

## Project Roadmap

- ### Version 0.1.0

  - [x] RKG File Reading (Feb 10th, 2024)
  - [x] Initial UI Window (Feb 10th, 2024)
  - [x] App Icon (Feb 19th, 2024)
  - [x] Tab Manager (Mar 3rd, 2024)
  - [x] Tab Close  (Mar 5th, 2024)
  - [x] Menu Bar (Mar 3rd, 2024)
  - [x] Dynamic Menu Bar (Mar 4th, 2024)
  - [x] About Window (Mar 3rd, 2024)
  - [x] File Opening (Mar 4th, 2024)
  - [x] (Batch) RKG File Renaming (Mar 5th, 2024)
  - [x] Initial Base Frame UI (May 7th, 2024)
  - [x] Get All Possible [Flag Icons](https://github.com/lipis/flag-icons) (May 7th, 2024)
  - [x] Render SVG Flag Files (July 24th, 2024)
  - [ ] Initial RKG UI
  - [ ] Implement [CTMKF](https://wiki.tockdom.com/wiki/CTMKF) Font for Mii Name Symbols
  - [x] Migrate Project to Maven (Mar 3rd, 2024)
  - [x] Building with Maven (Mar 4th, 2024)
  - [x] Implement Launch4j Maven Plugin (Mar 4th, 2024)

- ### Version 0.2.0

  - [ ] RKG File Saving
  - [ ] New Duplicate RKG from Current RKG
  - [ ] Mii CRC16-CCITT Checksum
  - [ ] RKG CRC-32 Checksum
  - [ ] RKG Compression/Decompression
  - [ ] Editing for Some Basic RKG Header Values
  - [ ] Warn User of Unsaved Files on Close/Exit
  - [ ] Ghost Mii Name Editing
  - [ ] Mii Data Exporting
  - [ ] Mii Data Replacement
  - [ ] Input Data Truncation

- ### Version 0.3.0

  - [ ] RKSYS File Reading
  - [ ] RKSYS File Creation
  - [ ] RKSYS File Exporting
  - [ ] RKSYS CRC-32 Checksum
  - [ ] RKSYS Edit Region
  - [ ] RKSYS Unlock All
  - [ ] Create License on RKSYS File
  - [ ] RKSYS Add Ghost from File
  - [ ] RKSYS Add Ghost from Open RKG
  - [ ] Open Ghost from RKSYS File
  - [ ] RKSYS UI

- ### Version 0.4.0

  - [ ] CTGP Extended Ghost Info Reading
  - [ ] CTGP Pause Input Reading
  - [ ] Strip CTGP Ghost Info
  - [ ] UI Extension for RKG files from CTGP
  - [ ] Add CTGP Extended Ghost Info to RKG UI
  - [ ] Add CTGP Database URL to RKG UI
  - [ ] Add CTGP Pause Input Viewing to RKG UI

- ### Version 1.0.0

  - [ ] Preferences Window
  - [ ] Preferences Saving
  - [ ] Preference: RKSYS Default Region
  - [ ] Preference: Show Region Prompt
  - [ ] Preference: Show Save Warning
  - [ ] Preference: Light Theme (FlatLaf Light)
  - [ ] Preference: Starting CD for File Opening
  - [ ] Preference: Hide Welcome Window on Startup
  - [ ] Menu Bar Keybindings
  - [ ] MacOS In-Window Menu Bar
  - [ ] Automatically Check for Updates

- ### Unplanned/Potential Features

  - [ ] Custom Top 10 Leaderboard Support
  - [ ] Export Input Display Video with [PyRKG](https://github.com/AtishaRibeiro/PyRKG)
  - [ ] Import Ghost from Ninrankings/MKLeaderboards/Chadsoft

## Credits

- [lipis/flag-icons](https://github.com/lipis/flag-icons) for the flag icons used in the UI.
- [Custom Mario Kart Wiiki](https://wiki.tockdom.com/wiki) for RKG/RKSYS file documentation.
