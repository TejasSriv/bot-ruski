
# Counter Strike Discord Bot

This bot is designed for a Counter-Strike server on Discord, providing a range of features for server management, fun interactions, and user engagement.

## Features

- **Welcome Message**: The bot sends a welcome message when a new user joins the server.
- **Fun Commands**: Commands like `!hello`, `!kick`, and `!ban` to interact with the server.
- **Kick and Ban Members**: The bot can kick and ban members from the server with appropriate permissions.

## Commands

- **!hello**: Sends a greeting message to the user.
- **!kick @user**: Kicks the mentioned user from the server.
- **!ban @user**: Bans the mentioned user from the server.

## Setup Instructions

### Prerequisites

- **Java**: Ensure you have JDK 8 or later installed on your machine.
- **Maven**: The project uses Maven for dependency management.
- **Discord Developer Token**: You will need to create a bot on the [Discord Developer Portal](https://discord.com/developers/applications) and get your bot token.

### Installation

1. Clone the repository:
    ```bash
    git clone https://github.com/TejasSriv/bot-ruski.git
    ```

2. Navigate to the project directory:
    ```bash
    cd your-repo-name
    ```

3. Create a `.env` file in the root directory and add your bot token to the `.env` file:
    ```bash
    BOT_TOKEN=your-bot-token-here
    ```

4. Install dependencies:
    ```bash
    mvn clean install
    ```

5. Run the bot:
    ```bash
    mvn exec:java
    ```

## Contributing

Feel free to fork the repository, create an issue, or submit a pull request for new features or bug fixes!
