package ssl.贝叶斯;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class NaiveBayesianBase {
    protected ArrayList<ArrayList<String>> trainingSet;

    public NaiveBayesianBase() {
        trainingSet=new ArrayList<ArrayList<String>>();
    }

    public abstract int inputTrainingSet() throws IOException;

    public abstract int readTrainingSet(String path) throws IOException;

    public static Map<String, ArrayList<ArrayList<String>>> dataClassification(ArrayList<ArrayList<String>> data) {//按照最后一个值分类
        Map<String, ArrayList<ArrayList<String>>> map=new HashMap<String, ArrayList<ArrayList<String>>>();
        ArrayList<String> line=null;
        String word="";
        for(int i=0;i<data.size();++i) {
            line=data.get(i);
            word=line.get(line.size()-1);
            if(map.containsKey(word)) map.get(word).add(line);
            else {
                ArrayList<ArrayList<String>> newLine=new ArrayList<ArrayList<String>>();
                newLine.add(line);
                map.put(word, newLine);
            }
        }
        Object[] c=map.keySet().toArray();
        //for(int i=0;i<c.length;++i) System.out.println(c[i].toString()+"，"+map.get(c[i]).size());
        return map;
    }

    public String predictClassification(ArrayList<String> testSet) {
        Map<String, ArrayList<ArrayList<String>>> doc=dataClassification(trainingSet);
        //保存训练集属性于数组中
        Object[] classificationAttributes=doc.keySet().toArray();
        double maxP=0.00;
        int maxPIndex=-1;
        for(int i=0;i<doc.size();++i) {
            String word=classificationAttributes[i].toString();
            ArrayList<ArrayList<String>> line=doc.get(word);
            BigDecimal b1=new BigDecimal(Double.toString(line.size()));
            BigDecimal b2=new BigDecimal(Double.toString(trainingSet.size()));
            double pClassification=b1.divide(b2, 3, RoundingMode.HALF_UP).doubleValue();
            int cn=trainingSet.get(0).size()-1>testSet.size()?testSet.size():trainingSet.get(0).size()-1;
            for(int k=0;k<cn;++k) {
                double pCA=pOfClassificationAttributes(testSet.get(k), k,classificationAttributes[i].toString());
                if(pCA<=0.00) pCA=1.0/doc.get(classificationAttributes[i].toString()).size();
                pClassification=new BigDecimal(Double.toString(pClassification)).multiply(new BigDecimal(Double.toString(pCA))).doubleValue();
            }
            if(pClassification>maxP) {
                maxP=pClassification;
                maxPIndex=i;
            }
        }
        //System.out.println(classificationAttributes[maxPIndex].toString());
        return classificationAttributes[maxPIndex].toString();
    }

    public double pOfClassificationAttributes(String attribute,int index,String classificationclass) {
        double p=0.0;
        int count=0;
        int total=0;
        for(int i=0;i<trainingSet.size();++i) {
            if(trainingSet.get(i).get(trainingSet.get(i).size()-1).equals(classificationclass)) {
                ++total;
                if(trainingSet.get(i).get(index).equals(attribute)) ++count;
            }
        }
        BigDecimal b1=new BigDecimal(Double.toString(count));
        BigDecimal b2=new BigDecimal(Double.toString(total));
        p=b1.divide(b2, 3, RoundingMode.HALF_UP).doubleValue();
        //System.out.println(total+" "+count+"\t"+attribute+"\t"+classificationclass);
        return p;
    }

    public void reportModel(double d) { //比例为d的数据做测试集
        if(d<0.0||d>1.0) return;
        ArrayList<ArrayList<String>> testSet=new ArrayList<ArrayList<String>>();
        int testSetCount=(int) (trainingSet.size()*d);
        for(int i=0;i<testSetCount;++i) testSet.add(trainingSet.remove((int)(Math.random()*(trainingSet.size()-1))));

        Map<String, Integer> counts=new HashMap<String, Integer>();
        Map<String, Integer> real=new HashMap<String, Integer>();
        Map<String, ArrayList<ArrayList<String>>> doc=dataClassification(testSet);
        Object[] objects=doc.keySet().toArray();
        for(int i=0;i<objects.length;++i) {
            real.put(objects[i].toString(), doc.get(objects[i]).size());
            counts.put(objects[i].toString(), 0);
        }
        for(int i=0;i<testSet.size();++i) {
            String key=predictClassification(testSet.get(i));
            counts.replace(key, counts.get(key)+1);
        }

        double p=0.0;
        for(int i=0;i<objects.length;++i)
            p+=((double)Math.abs(real.get(objects[i])-counts.get(objects[i])))/testSetCount;
        System.out.println("模型准确率为："+(1.0-p));
        for(int i=0;i<testSetCount;++i) trainingSet.add(testSet.get(i));
    }

    public void reportModelSelf() {
        Map<String, Integer> counts=new HashMap<String, Integer>();
        Map<String, Integer> real=new HashMap<String, Integer>();
        Map<String, ArrayList<ArrayList<String>>> doc=dataClassification(trainingSet);
        Object[] objects=doc.keySet().toArray();
        for(int i=0;i<objects.length;++i) {
            real.put(objects[i].toString(), doc.get(objects[i]).size());
            counts.put(objects[i].toString(), 0);
        }
        for(int i=0;i<trainingSet.size();++i) {
            String key=predictClassification(trainingSet.get(i));
            counts.replace(key, counts.get(key)+1);
        }

        double p=0.0;
        for(int i=0;i<objects.length;++i)
            p+=((double)Math.abs(real.get(objects[i])-counts.get(objects[i])))/trainingSet.size();
        System.out.println("模型准确率为："+(1.0-p));
    }
}
