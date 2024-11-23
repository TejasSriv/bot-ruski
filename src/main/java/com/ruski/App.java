package com.ruski;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class App extends ListenerAdapter {
    public static void main(String[] args) throws Exception {
        String token = System.getenv("BOT_TOKEN");
        JDABuilder.createDefault(token)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new App(), new KickCommand())
                .build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        String content = message.getContentRaw();

        if (content.equalsIgnoreCase("!hello")) {
            event.getChannel().sendMessage("Hello there.").queue();
        }
        if (content.equalsIgnoreCase("!website")) {
            event.getChannel().sendMessage("We are working on it.").queue();
        }
        if (content.equalsIgnoreCase("!youtube")) {
            event.getChannel().sendMessage("We are working on it.").queue();
        }
        if (content.equalsIgnoreCase("!help")) {
            event.getChannel().sendMessage("!help, !hello, !website, !youtube").queue();
        }
    }
}