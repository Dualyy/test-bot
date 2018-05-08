package yuki.dev;

import org.javacord.DiscordApi;
import org.javacord.DiscordApiBuilder;
import org.javacord.util.logging.LoggerUtil;


public class Main {
	
	public static void main(String[] args) {
		
		if(args.length < 1) {
			System.err.println("please provide a Token as argument!");
			return;
		}
		
		//debug enable
		LoggerUtil.setDebug(true);
		//Token = first argument
		String token = args[0];
		//build bot
		DiscordApi api = new DiscordApiBuilder().setToken(token).login().join();
		//print inv URL
		System.out.println("You can invite me using following Link: " + api.createBotInvite());
		//Log message for server join/leave
		api.addServerJoinListener(event -> System.out.println("Joined server " + event.getServer().getName()));
		api.addServerLeaveListener(event -> System.out.println("left Server " + event.getServer().getName()));
		//CommandListener
		//test for listening to VC join events
		api.addServerVoiceChannelMemberJoinListener(event -> System.out.println("hello " + event.getUser().getName()));
		System.out.println(api.getStatus().toString());
		System.out.println("wtf");
		
		
	}

}

