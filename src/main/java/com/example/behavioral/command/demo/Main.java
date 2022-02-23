package com.example.behavioral.command.demo;

import com.example.behavioral.command.demo.commands.StartFanCommand;
import com.example.behavioral.command.demo.commands.StopFanCommand;
import com.example.behavioral.command.demo.commands.TurnOnLightCommand;
import com.example.behavioral.command.demo.invoker.HomeAutomationRemote;
import com.example.behavioral.command.demo.receivers.Fan;
import com.example.behavioral.command.demo.receivers.Light;

/**
 * Demo class for HomeAutomation
 */
public class Main{ // client

    public static void main(String[] args) {
        Light livingRoomLight = new Light();  //receiver 1

        Fan livingRoomFan = new Fan();  //receiver 2

        Light bedRoomLight = new Light(); //receiver 3

        Fan bedRoomFan = new Fan();   //receiver 4

        HomeAutomationRemote remote = new HomeAutomationRemote(); //Invoker

        remote.setCommand(new TurnOnLightCommand(livingRoomLight)); // command
        remote.buttonPressed();

        remote.setCommand(new TurnOnLightCommand(bedRoomLight)); // command
        remote.buttonPressed();

        remote.setCommand(new StartFanCommand(livingRoomFan)); // command
        remote.buttonPressed();

        remote.setCommand(new StopFanCommand(livingRoomFan)); // command
        remote.buttonPressed();

        remote.setCommand(new StartFanCommand(bedRoomFan)); // command
        remote.buttonPressed();

        remote.setCommand(new StopFanCommand(bedRoomFan)); // command
        remote.buttonPressed();
    }
}