package me.plich.cashregistersystem.command.devices;

import me.plich.cashregistersystem.model.Device;


public class SetMobileDeviceCommand implements IDeviceCommand {

    private Device device;

    public SetMobileDeviceCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.setLocation(null);
        device.setMobile(true);
    }
}
