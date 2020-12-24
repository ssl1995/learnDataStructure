package ssl.贝叶斯;

import java.io.*;
import java.util.ArrayList;

public class PatientClassification extends NaiveBayesianBase {

    @Override
    public int inputTrainingSet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while (!(str = reader.readLine()).equals("")) {
            String[] tokenizer = str.split(",");
            ArrayList<String> s = new ArrayList<String>();
            for(int i=0;i<tokenizer.length;i++){
                s.add(tokenizer[i]);
            }
            trainingSet.add(dataDeal(s));
        }
        return 0;
    }

    @Override
    public int readTrainingSet(String path) throws IOException {
        File file=new File(path);
        if(!file.exists()||!file.isFile()) {
            System.out.println(file.getAbsolutePath());
            return -1;
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String str = "";
        while ((str=reader.readLine())!=null) {
            String[] tokenizer = str.split(",");
            ArrayList<String> s = new ArrayList<String>();
            for(int i=0;i<tokenizer.length;i++){
                s.add(tokenizer[i]);
            }
            trainingSet.add(dataDeal(s));
        }
        reader.close();
        return 0;
    }

    private static ArrayList<String> dataDeal(ArrayList<String> line) {
        ArrayList<String> newLine=new ArrayList<String>();
        int temp=-1;
        double tempDouble=0.0;
        //Age
        switch ((Integer.parseInt(line.get(0))+2)/5) {
            case 0:case 1:case 2:case 3:case 4:case 5:case 6:newLine.add("1");break;
            case 7:newLine.add("2");break;
            case 8:newLine.add("3");break;
            case 9:newLine.add("4");break;
            case 10:newLine.add("5");break;
            case 11:newLine.add("6");break;
            case 12:newLine.add("7");break;
            default:newLine.add("-1");break;
        }
        //Gender
        newLine.add(line.get(1));
        //BMI
        temp=Integer.parseInt(line.get(2));
        if(temp<18) newLine.add("1");
        else if(temp<25) newLine.add("2");
        else newLine.add(String.valueOf(temp/5-2));
        //Fever,Nausea/Vomiting,Headache,Diarrhea,Fatigue & Bone ache,Jaundice,Epigastria pain 7 Absent/Present
        for(int i=0;i<7;++i) newLine.add(line.get(i+3));
        //WBC 10
        temp=Integer.parseInt(line.get(10));
        if(temp<4000) newLine.add("1");
        else if(temp<11000) newLine.add("2");
        else newLine.add("3");
        //RBC 11
        tempDouble=Double.parseDouble(line.get(11));
        if(tempDouble<3000000.00) newLine.add("1");
        else if(tempDouble<5000000.00) newLine.add("2");
        else newLine.add("3");
        //HGB 12
        temp=Integer.parseInt(line.get(12));
        if(newLine.get(1).equals("1")) {
            if(temp<14) newLine.add("1");
            else if(temp<=17) newLine.add("2");
            else newLine.add("3");
        }
        else {
            if(temp<12) newLine.add("1");
            else if(temp<=15) newLine.add("2");
            else newLine.add("3");
        }
        //Plat
        tempDouble=Double.parseDouble(line.get(13));
        if(tempDouble<100000.00) newLine.add("1");
        else if(tempDouble<255000) newLine.add("2");
        else newLine.add("3");
        //AST1,ALT1,ALT4,ALT12,ALT24,ALT36,ALT48,ALT after 24  8
        for(int i=0;i<8;++i) {
            tempDouble=Double.parseDouble(line.get(i+14));
            if(tempDouble<20.00) newLine.add("1");
            else if(tempDouble<=40.00) newLine.add("2");
            else newLine.add("3");
        }
        //RNA Base,RNA 4,RNA 12,RNA EOT,RNA EF  22 5
        for(int i=0;i<5;++i) {
            tempDouble=Double.parseDouble(line.get(22+i));
            if(tempDouble<=5.00) newLine.add("1");
            else newLine.add("2");
        }
        //Baseline Histological Grading 27
        newLine.add(line.get(27));
        //Baseline Histological 28 分类4类
        if(line.size()>newLine.size()) newLine.add(line.get(line.size()-1));
        return newLine;
    }

    public static void main(String[] args) {
        PatientClassification patientClassification=new PatientClassification();
        try {
            patientClassification.readTrainingSet("patientData.txt");
            patientClassification.reportModelSelf();
            patientClassification.reportModel(0.10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

