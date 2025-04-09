/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.List;

/**
 * @author Michael Sanchez
 */
public class Screen {
    private String name;
    private String type;
    //private ArrayList <String> seatSelection;
    private ArrayList <String> seatList;
    private ArrayList <Screen> screens;
    private ArrayList <String> seating;
    private double seatCost;
    
        public Screen(String n, String t) {
        screens = new ArrayList();
        seating = new ArrayList();
        this.seatList = new ArrayList<>();
        //this.seatSelection = new ArrayList<>();
        name = n;
        type = t;
        if (type == "imax") {
            this.seatCost = 20.0;
        } else {
            this.seatCost = 11.50;
        }
        if (type == "imax") {
            seatList.addAll(Arrays.asList("A01", "A02", "A03", "A04", "A05", "A06", "A07", "A08", "A09", "A10",
                   "B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09", "B10",
                   "C01", "C02", "C03", "C04", "C05", "C06", "C07", "C08", "C09", "C10",
                   "D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09", "D10",
                   "E01", "E02", "E03", "E04", "E05", "E06", "E07", "E08", "E09", "E10",
                   "F01", "F02", "F03", "F04", "F05", "F06", "F07", "F08", "F09", "F10",
                   "G01", "G02", "G03", "G04", "G05", "G06", "G07", "G08", "G09", "G10",
                   "H01", "H02", "H03", "H04", "H05", "H06", "H07", "H08", "H09", "H10"));
            seating.addAll(seatList);
            
        }else {
           seatList.addAll(Arrays.asList("A01", "A02", "A03", "A04", "A05", "A06", "A07", "A08", "A09", "A10", "A11", "A12", "A13", "A14",
                   "B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09", "B10", "B11", "B12", "B13", "B14",
                   "C01", "C02", "C03", "C04", "C05", "C06", "C07", "C08", "C09", "C10", "C11", "C12", "C13", "C14",
                   "D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09", "D10", "D11", "D12", "D13", "D14",
                   "E01", "E02", "E03", "E04", "E05", "E06", "E07", "E08", "E09", "E10", "E11", "E12", "E13", "E14",
                   "F01", "F02", "F03", "F04", "F05", "F06", "F07", "F08", "F09", "F10", "F11", "F12", "F13", "F14",
                   "G01", "G02", "G03", "G04", "G05", "G06", "G07", "G08", "G09", "G10", "G11", "G12", "G13", "G14",
                   "H01", "H02", "H03", "H04", "H05", "H06", "H07", "H08", "H09", "H10", "H11", "H12", "H13", "H14")); 
           seating.addAll(seatList);
        }
        
        }
        
        public Screen(String n) {
        screens = new ArrayList();
        seating = new ArrayList();
        this.seatList = new ArrayList<>();
        //this.seatSelection = new ArrayList<>();
        name = n;
        type = "Regular";
        seatCost = 11.50;
        seatList.addAll(Arrays.asList("A01", "A02", "A03", "A04", "A05", "A06", "A07", "A08", "A09", "A10", "A11", "A12", "A13", "A14",
                   "B01", "B02", "B03", "B04", "B05", "B06", "B07", "B08", "B09", "B10", "B11", "B12", "B13", "B14",
                   "C01", "C02", "C03", "C04", "C05", "C06", "C07", "C08", "C09", "C10", "C11", "C12", "C13", "C14",
                   "D01", "D02", "D03", "D04", "D05", "D06", "D07", "D08", "D09", "D10", "D11", "D12", "D13", "D14",
                   "E01", "E02", "E03", "E04", "E05", "E06", "E07", "E08", "E09", "E10", "E11", "E12", "E13", "E14",
                   "F01", "F02", "F03", "F04", "F05", "F06", "F07", "F08", "F09", "F10", "F11", "F12", "F13", "F14",
                   "G01", "G02", "G03", "G04", "G05", "G06", "G07", "G08", "G09", "G10", "G11", "G12", "G13", "G14",
                   "H01", "H02", "H03", "H04", "H05", "H06", "H07", "H08", "H09", "H10", "H11", "H12", "H13", "H14")); 
        seating.addAll(seatList);
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Screen> getScreens() {
        return screens;
    }

    public void setScreens(ArrayList<Screen> screens) {
        this.screens = screens;
    }

    //If tp is "imax", assign different seating
    public void setSeating() {
        
        if (type == "imax") {
            seatList.addAll(Arrays.asList("RA1, RA2, RA3"));
            seating.addAll(seatList);
            
        }else {
           seatList.addAll(Arrays.asList("IA1, IA2, IA3")); 
           seating.addAll(seatList);
        }
    }

    public double getSeatCost() {
        return seatCost;
    }
    
    public ArrayList<String> getSeatList() {
        return seatList;
    }
    
    public ArrayList<String> getSeating() {
        return seating;
    }
    
    public void displaySeating(Screen screen) {
        //System.out.println("displaying screen");
        ArrayList<String>d = new ArrayList<>();
        String t = screen.getType();
        d = screen.getSeating();
        //System.out.println(d);
        if (t.equals("imax")) { 
            System.out.println("\t========================   SCREEN   ========================");
            System.out.println();
            System.out.println("||\t[" + d.get(0) + "] [" + d.get(1) + "] [" + d.get(2) + "] [" + d.get(3) + "] [" + d.get(4) + "] [" + d.get(5) + "] [" + d.get(6) + "] [" + d.get(7) + "] [" + d.get(8) + "] [" + d.get(9) + "]\t ||   ||");
            System.out.println("||\t[" + d.get(10) + "] [" + d.get(11) + "] [" + d.get(12) + "] [" + d.get(13) + "] [" + d.get(14) + "] [" + d.get(15) + "] [" + d.get(16) + "] [" + d.get(17) + "] [" + d.get(18) + "] [" + d.get(19) + "]\t ||   ||");
            System.out.println("||\t[" + d.get(20) + "] [" + d.get(21) + "] [" + d.get(22) + "] [" + d.get(23) + "] [" + d.get(24) + "] [" + d.get(25) + "] [" + d.get(26) + "] [" + d.get(27) + "] [" + d.get(28) + "] [" + d.get(29) + "]\t || E ||");
            System.out.println("||\t[" + d.get(30) + "] [" + d.get(31) + "] [" + d.get(32) + "] [" + d.get(33) + "] [" + d.get(34) + "] [" + d.get(35) + "] [" + d.get(36) + "] [" + d.get(37) + "] [" + d.get(38) + "] [" + d.get(39) + "]\t || X ||");
            System.out.println("||\t[" + d.get(40) + "] [" + d.get(41) + "] [" + d.get(42) + "] [" + d.get(43) + "] [" + d.get(44) + "] [" + d.get(45) + "] [" + d.get(46) + "] [" + d.get(47) + "] [" + d.get(48) + "] [" + d.get(49) + "]\t || I ||");
            System.out.println("||\t[" + d.get(50) + "] [" + d.get(51) + "] [" + d.get(52) + "] [" + d.get(53) + "] [" + d.get(54) + "] [" + d.get(55) + "] [" + d.get(56) + "] [" + d.get(57) + "] [" + d.get(58) + "] [" + d.get(59) + "]\t || T ||");
            System.out.println("||\t[" + d.get(60) + "] [" + d.get(61) + "] [" + d.get(62) + "] [" + d.get(63) + "] [" + d.get(64) + "] [" + d.get(65) + "] [" + d.get(66) + "] [" + d.get(67) + "] [" + d.get(68) + "] [" + d.get(69) + "]\t ||   ||");
            System.out.println("||\t[" + d.get(70) + "] [" + d.get(71) + "] [" + d.get(72) + "] [" + d.get(73) + "] [" + d.get(74) + "] [" + d.get(75) + "] [" + d.get(76) + "] [" + d.get(77) + "] [" + d.get(78) + "] [" + d.get(79) + "]\t ||   ||");  
        }else { 
            System.out.println("\t===================================   SCREEN   ===================================");
            System.out.println();
            System.out.println("||\t[" + d.get(0) + "] [" + d.get(1) + "] [" + d.get(2) + "] [" + d.get(3) + "] [" + d.get(4) + "] [" + d.get(5) + "] [" + d.get(6) + "] [" + d.get(7) + "] [" + d.get(8) + "] [" + d.get(9) +"] [" + d.get(10) + "] [" + d.get(11) + "] [" + d.get(12) + "] [" + d.get(13) + "]\t ||   ||");
            System.out.println("||\t[" + d.get(14) + "] [" + d.get(15) + "] [" + d.get(16) + "] [" + d.get(17) + "] [" + d.get(18) + "] [" + d.get(19) + "] [" + d.get(20) + "] [" + d.get(21) + "] [" + d.get(22) + "] [" + d.get(23) +"] [" + d.get(24) + "] [" + d.get(25) + "] [" + d.get(26) + "] [" + d.get(27) + "]\t ||   ||");
            System.out.println("||\t[" + d.get(28) + "] [" + d.get(29) + "] [" + d.get(30) + "] [" + d.get(31) + "] [" + d.get(32) + "] [" + d.get(33) + "] [" + d.get(34) + "] [" + d.get(35) + "] [" + d.get(36) + "] [" + d.get(37) +"] [" + d.get(38) + "] [" + d.get(39) + "] [" + d.get(40) + "] [" + d.get(41) + "]\t || E ||");
            System.out.println("||\t[" + d.get(42) + "] [" + d.get(43) + "] [" + d.get(44) + "] [" + d.get(45) + "] [" + d.get(46) + "] [" + d.get(47) + "] [" + d.get(48) + "] [" + d.get(49) + "] [" + d.get(50) + "] [" + d.get(51) +"] [" + d.get(52) + "] [" + d.get(53) + "] [" + d.get(54) + "] [" + d.get(55) + "]\t || X ||");
            System.out.println("||\t[" + d.get(56) + "] [" + d.get(57) + "] [" + d.get(58) + "] [" + d.get(59) + "] [" + d.get(60) + "] [" + d.get(61) + "] [" + d.get(62) + "] [" + d.get(63) + "] [" + d.get(64) + "] [" + d.get(65) +"] [" + d.get(66) + "] [" + d.get(67) + "] [" + d.get(68) + "] [" + d.get(69) + "]\t || I ||");
            System.out.println("||\t[" + d.get(70) + "] [" + d.get(71) + "] [" + d.get(72) + "] [" + d.get(73) + "] [" + d.get(74) + "] [" + d.get(75) + "] [" + d.get(76) + "] [" + d.get(77) + "] [" + d.get(78) + "] [" + d.get(79) +"] [" + d.get(80) + "] [" + d.get(81) + "] [" + d.get(82) + "] [" + d.get(83) + "]\t || T ||");
            System.out.println("||\t[" + d.get(84) + "] [" + d.get(85) + "] [" + d.get(86) + "] [" + d.get(87) + "] [" + d.get(88) + "] [" + d.get(89) + "] [" + d.get(90) + "] [" + d.get(91) + "] [" + d.get(92) + "] [" + d.get(93) +"] [" + d.get(94) + "] [" + d.get(95) + "] [" + d.get(96) + "] [" + d.get(97) + "]\t ||   ||");
            System.out.println("||\t[" + d.get(98) + "] [" + d.get(99) + "] [" + d.get(100) + "] [" + d.get(101) + "] [" + d.get(102) + "] [" + d.get(103) + "] [" + d.get(104) + "] [" + d.get(105) + "] [" + d.get(106) + "] [" + d.get(107) +"] [" + d.get(108) + "] [" + d.get(109) + "] [" + d.get(110) + "] [" + d.get(111) + "]\t ||   ||");  
        } 
    }
    
    @Override
    public String toString() {
        return "Name: " + name + " Type: " + type + "\n" + seating;
    }
}
