package com.ruski;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class KickCommand extends ListenerAdapter {

    @SuppressWarnings("deprecation")
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();

        // If the message starts with !kick
        if (message.startsWith("!kick")) {
            // Check if the bot has permission to kick members
            if (!event.getGuild().getSelfMember().hasPermission(Permission.KICK_MEMBERS)) {
                event.getChannel().sendMessage("I don't have permission to kick members.").queue();
                return;
            }

            // Check if the sender has permission to kick members
            if (!event.getMember().hasPermission(Permission.KICK_MEMBERS)) {
                event.getChannel().sendMessage("You don't have permission to kick members.").queue();
                return;
            }

            // Extract the mentioned user from the message
            String[] parts = message.split(" ");
            if (parts.length < 2) {
                event.getChannel().sendMessage("Please mention a user to kick.").queue();
                return;
            }

            // Get the mentioned member
            Member memberToKick = event.getMessage().getMentions().getMembers().get(0);
            if (memberToKick != null) {
                event.getGuild().kick(memberToKick, "Kicked by bot for inappropriate behavior").queue(
                        success -> event.getChannel()
                                .sendMessage(memberToKick.getUser().getAsTag() + " has been kicked.").queue(),
                        failure -> event.getChannel().sendMessage("Failed to kick the member.").queue());
            }
        }
    }
}
