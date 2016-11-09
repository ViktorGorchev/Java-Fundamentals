package database;

import contracts.DatabaseInterface;
import contracts.HardwareInterface;
import contracts.SoftwareInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Database implements DatabaseInterface{
    private List<HardwareInterface> hardwareData;
    private LinkedHashMap<String, List<SoftwareInterface>> hardwareAndSoftwareData;
    private List<HardwareInterface> dumpedHardwareData;
    private LinkedHashMap<String, List<SoftwareInterface>> dumpedHardwareAndSoftwareData;

    public Database() {
        this.hardwareData = new ArrayList<>();
        this.hardwareAndSoftwareData = new LinkedHashMap<>();
        this.dumpedHardwareData = new ArrayList<>();
        this.dumpedHardwareAndSoftwareData = new LinkedHashMap<>();
    }

    private HardwareInterface getNotDumedHardware(String name){
        for (HardwareInterface currentHardware : hardwareData) {
            if(currentHardware.getName().equals(name)){
                return currentHardware;
            }
        }

        return null;
    }

    private HardwareInterface getDumpedHardware(String name){
        for (HardwareInterface currentHardware : dumpedHardwareData) {
            if(currentHardware.getName().equals(name)){
                return currentHardware;
            }
        }

        return null;
    }

    private SoftwareInterface getSoftware(String name){
        SoftwareInterface software = null;
        for (Map.Entry<String,List<SoftwareInterface>> data : hardwareAndSoftwareData.entrySet()) {
            for (SoftwareInterface softData : data.getValue()) {
                if(softData.getName().equals(name)){
                   return softData;
                }
            }


        }

        return software;
    }

    public void addHardware(HardwareInterface hardware){

        if(! hardwareAndSoftwareData.containsKey(hardware.getName())){
            hardwareAndSoftwareData.put(hardware.getName(), new ArrayList<>());
            hardwareData.add(hardware);
        }

    }

    public void moveHardwareToDump(String name){
       if(hardwareAndSoftwareData.containsKey(name)){
           dumpedHardwareData.add(getNotDumedHardware(name));
           dumpedHardwareAndSoftwareData.put(name, hardwareAndSoftwareData.get(name));

           hardwareAndSoftwareData.remove(name);
           hardwareData.remove(getNotDumedHardware(name));
       }
    }

    public void addSoftware(SoftwareInterface software){
        hardwareAndSoftwareData.get(software.getInstalledOnHardware()).add(software);
    }

    public void removeSoftware(String name){
        SoftwareInterface software = getSoftware(name);
        hardwareAndSoftwareData.get(software.getInstalledOnHardware()).remove(software);
    }

    public void restoreHardwareFromDump(String name){

        if(dumpedHardwareAndSoftwareData.containsKey(name)){
            hardwareData.add(getDumpedHardware(name));
            hardwareAndSoftwareData.put(name, dumpedHardwareAndSoftwareData.get(name));

            removeHardwareFromDump(name);
        }
    }

    public void removeHardwareFromDump(String name){
        if(dumpedHardwareAndSoftwareData.containsKey(name)){
            dumpedHardwareData.remove(name);
            dumpedHardwareAndSoftwareData.remove(name);
        }
    }

    public String systemAnalysis(){
        StringBuilder analysis = new StringBuilder();
       // TODO

        return analysis.toString();
    }

    public String finalDataAnalysis(){
        StringBuilder finalAnalysis = new StringBuilder();
        //TODO

        return finalAnalysis.toString();
    }
}