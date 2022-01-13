package com.epam.ta.service;

import com.epam.ta.model.CalculatorData;

public class CalculatorDataCreator {

    public static final String INSTANCES = "calculator.data.instances";
    public static final String OS = "calculator.data.os";
    public static final String MACHINE_CLASS = "calculator.data.machine.class";
    public static final String SERIES = "calculator.data.series";
    public static final String MACHINE_TYPE = "calculator.data.machine.type";
    public static final String GPU = "calculator.data.gpu";
    public static final String GPU_TYPE = "calculator.data.gpu.type";
    public static final String GPU_NUMBER = "calculator.data.gpu.number";
    public static final String SSD = "calculator.data.ssd";
    public static final String LOCATION = "calculator.data.location";
    public static final String USAGE = "calculator.data.committed.usage";

    public static CalculatorData createTestData() {
        CalculatorData data  = new CalculatorData();
        data.setInstances(TestDataReader.getTestData(INSTANCES));
        data.setOs(TestDataReader.getTestData(OS));
        data.setVmClass(TestDataReader.getTestData(MACHINE_CLASS));
        data.setSeries(TestDataReader.getTestData(SERIES));
        data.setInstanceType(TestDataReader.getTestData(MACHINE_TYPE));
        data.setAddGPUs(Boolean.parseBoolean(TestDataReader.getTestData(GPU)));
        data.setGpuType(TestDataReader.getTestData(GPU_TYPE));
        data.setNumberOfGPUs(TestDataReader.getTestData(GPU_NUMBER));
        data.setSsd(TestDataReader.getTestData(SSD));
        data.setLocation(TestDataReader.getTestData(LOCATION));
        data.setCommittedUsage(TestDataReader.getTestData(USAGE));
        return data;
    }
}
