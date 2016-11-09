import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dragons {
    public static void main(String[] args) {
        ///LinkedHashSet

        Scanner console = new Scanner(System.in);
        long numberDragons = console.nextLong();

        List<Dragon> allDragons = new ArrayList<>();
        for (int i = 0; i < numberDragons; i++) {
            Long numberOfEggs = console.nextLong();
            List<Long> eggs = new ArrayList<>();
            for (int j = 0; j < numberOfEggs; j++) {
                eggs.add(0L);
            }
            String dragonName = "Dragon_" + (i + 1);
            allDragons.add(new Dragon(dragonName, 0, eggs, null, 0));
        }

        int years = console.nextInt();

        List<String> yearsType = new ArrayList<>();
        for (int i = 0; i < years; i++) {
            yearsType.add(console.next());
        }

        Long childrenNumber = numberDragons;

        for (int i = 0; i < years; i++) {
            String currentYearType = yearsType.get(i);
            for (int j = 0; j < allDragons.size(); j++) {
                Dragon currentDragon = allDragons.get(j);
                currentDragon.age++;
                if(currentDragon.age >= 6){
                    allDragons.remove(currentDragon);
                    continue;
                }

                List<Long> eggs = new ArrayList<>();
                for (int k = 0; k < currentDragon.egs.size(); k++) {
                    Long egg = currentDragon.egs.get(k);
                    egg++;
                    eggs.add(egg);
                }

                currentDragon.egs = eggs;

                if(allDragons.get(j).age == 3 || allDragons.get(j).age == 4){
                    currentDragon.egs.add(0L);
                }

                if(currentYearType.equals("Bad")){
                    for (int k = 0; k < currentDragon.egs.size(); k++) {
                        if (currentDragon.egs.get(k) >= 2){
                            currentDragon.egs.remove(k);
                        }
                    }
                }

                if(currentYearType.equals("Normal")){
                    //int childrenNumber =
                            //Integer.parseInt(Character.toString(currentDragon.name.charAt(currentDragon.name.length() - 1)));
                    for (int k = 0; k < currentDragon.egs.size(); k++) {
                        if (currentDragon.egs.get(k) < 2){
                            continue;
                        }

                        currentDragon.egs.remove(k);
                        childrenNumber++;
                        String newDragonName = currentDragon.name + "/Dragon_" + childrenNumber;
                        allDragons.add(new Dragon(newDragonName, 0, new ArrayList<>(), currentDragon.name, currentDragon.indent + 1));
                        currentDragon.children.add(newDragonName);
                    }
                }

                if(currentYearType.equals("Good")){
                    //int childrenNumber =
                            //Integer.parseInt(Character.toString(currentDragon.name.charAt(currentDragon.name.length() - 1)));
                    for (int k = 0; k < currentDragon.egs.size(); k++) {
                        if (currentDragon.egs.get(k) < 2){
                            continue;
                        }

                        currentDragon.egs.remove(k);
                        childrenNumber++;
                        String newDragonName = currentDragon.name + "/Dragon_" + childrenNumber;
                        allDragons.add(new Dragon(newDragonName, 0, new ArrayList<>(), currentDragon.name, currentDragon.indent + 1));
                        currentDragon.children.add(newDragonName);

                        childrenNumber++;
                        String newSecondDragonName = currentDragon.name + "/Dragon_" + childrenNumber;
                        allDragons.add(new Dragon(newSecondDragonName, 0, new ArrayList<>(), currentDragon.name, currentDragon.indent + 1));
                        currentDragon.children.add(newSecondDragonName);
                    }
                }
            }
        }

        List<String> parents = new ArrayList<>();
        for (Dragon dragon : allDragons) {

            System.out.print(new String(new char[dragon.indent]).replace("\0", " "));
            System.out.println(dragon.name);
        }
    }
}

class Dragon{
    public String name;
    public int age;
    public List<Long> egs;
    public String parent;
    public List<String> children;
    public int indent;

    public Dragon(String name, int age, List<Long> egs, String parent, int indent) {
        this.name = name;
        this.age = age;
        this.egs = egs;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.indent = indent;
    }
}


