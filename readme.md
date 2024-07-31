# WorldDelete Plugin

The WorldDelete Plugin is a Paper plugin designed to help manage and delete Minecraft world data whenever the server is restarted. This was developed for minigame servers that need to regenerate a world whenver the server restarts, or to delete user information.

## Supported Versions
Right now the plugin has only been tested on Paper 1.21

## Features

- **Selective Deletion**: Choose specific world components to delete, such as advancements, data, entities, and more.
- **Delete All Option**: Quickly delete all files within a specified world directory.
- **Configurable**: Easily configure which worlds and which parts of each world to delete through a YAML configuration file.

## Installation

1. **Download the Plugin**:
    - Obtain the `WorldDelete.jar` file from the latest releases on the GitHub repository.

2. **Server Setup**:
    - Place the `WorldDelete.jar` file in your server's `plugins` directory.

3. **Restart the Server**:
    - Restart your server to load the plugin. This can be done by stopping and starting the server or by using a restart command.

## Configuration

Edit the `config.yml` file in the plugin's folder after the first run to set up your preferences. Here is a typical configuration structure:

```yaml
# List of all worlds that can be deleted
worlds-to-delete:
  # Name of the world folder
  exampleWorld:
    delete-all: false  # Whether to delete all contents of the world folder
    # If delete all is false the following choose which of the worlds folder's to delete
    advancements: true
    data/raids.dat: true # Use a / to delete a specific file within a folder
    datapacks: false
    entities: true
    poi: true
    region: true
    stats: true
    level__dat: true # Replace . with __
    paper-world__yml: false # Replace . with __
    uid__dat: false # Replace . with __
```

## Planned Features

- Have a directory of worlds to copy in after one is deleted
- Allow setting and changing the seed of a world when it is deleted
- Allow deleting a world while the server is runnning

### Reporting Issues

If you encounter any bugs or issues with the WorldDelete Plugin, or if you have suggestions for improvements or new features, please report these to our GitHub repository.
### Contributing to Development

Contributions to the WorldDelete Plugin are welcome just make a PR :)


