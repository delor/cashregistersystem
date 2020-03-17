package me.plich.cashregistersystem.command.devices;


public class DeviceOperationExecutor {

    private IDeviceCommand deviceCommand;

    public DeviceOperationExecutor(IDeviceCommand deviceCommand) {
        this.deviceCommand = deviceCommand;
    }

    public void executeOperations() {
            deviceCommand.execute();
    }
}
