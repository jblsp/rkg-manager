# <img src="src/main/resources/icon.png" alt="App Icon" style="width:32px;"> rkg-tool

GUI tool for Mario Kart Wii time trial ghost files (*.rkg) and Mario Kart Wii save files (rksys.dat).

## Images

<img src="images/baseframe.png" alt="Base Frame" style="width:750">

## Building from Source

### Instructions

1) Install [Apache Maven](https://maven.apache.org/).
2) Clone this repository.
3) Run `mvn package`. The output jar file and [launch4j](https://launch4j.sourceforge.net) executable will be in /target.

## Project Roadmap

- ### Version 0.1.0

  - [x] *.rkg File Handling (Feb 10th, 2024)
  - [x] Initial UI Window (Feb 10th, 2024)
  - [x] App Icon (Feb 19th, 2024)
  - [x] Tab Manager (Mar 3rd, 2024)
  - [ ] Tab Close Icon
  - [x] Menu Bar (Mar 3rd, 2024)
  - [x] Dynamic Menu Bar (Mar 4th, 2024)
  - [x] About Window (Mar 3rd, 2024)
  - [x] Error Handling Window (Mar 4th 2024)
  - [x] File Opening (Mar 4th 2024)
  - [ ] Open Prompts on Base Window
  - [ ] Open Multiple Files at Once
  - [ ] (Batch) RKG File Renaming
  - [ ] Custom Tabs with Close Button
  - [ ] Initial *.rkg UI
  - [x] Migrate Project to Maven (Mar 3rd, 2024)
  - [x] Building with Maven (Mar 4th, 2024)

- ### Version 0.2.0

  - [ ] RKG CRC16-CCITT-XModem Checksum
  - [ ] Editing for Some Basic *.rkg Header Values
  - [ ] Ghost Mii Name Editing
  - [ ] Mii Data Exporting
  - [ ] Mii Data Replacement
  - [ ] Input Data Truncation
  - [ ] *.rkg UI Changes

- ### Version 0.3.0

  - [ ] rksys.dat File Handling
  - [ ] rksys.dat File Creation
  - [ ] Preferences Window
  - [ ] Preferences Saving
  - [ ] Basic Preferences (New rksys.dat Defaults)
  - [ ] rksys.dat CRC-32 Checksum
  - [ ] rksys.dat Edit Region
  - [ ] rksys.dat Unlock All
  - [ ] Support Adding Ghosts to rksys.dat Files
  - [ ] rksys.dat UI

- ### 1.0.0

  - [ ] CTGP Extended Ghost Info Handling
  - [ ] CTGP Pause Inputs *.rkg Files Handling
  - [ ] UI Extension for *.rkg files from CTGP
  - [ ] Add CTGP Extended Ghost Info to *.rkg UI
  - [ ] Add CTGP Database URL to *.rkg UI
  - [ ] Add CTGP Pause Input Viewing to *.rkg UI

- ### Unplanned/Potential Features

  - [ ] Custom Top 10 Leaderboard File Format
  - [ ] Export Input Display Video with [PyRKG](https://github.com/AtishaRibeiro/PyRKG)
  - [ ] Import Ghost from Ninrankings/MKLeaderboards/Chadsoft
