package mst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.javatuples.Triplet;
import mst.Vector;

public class Prims {

public ArrayList<Triplet<Integer,Integer,Double>> mst (ArrayList<Vector>  record){
	
	Vector r = record.get(0);
	int[] l = new int[2];
	
	ArrayList<PrimVex> dv = new ArrayList<PrimVex>();
	
	for ( int i =0; i< record.size()-1;i++ ) {
		if(record.get(i) != r) {
			dv.add(new PrimVex(i,0,record.get(i).Distance(r)));
		}
	}
	
	ArrayList<Triplet<Integer,Integer,Double>> res = new ArrayList<Triplet<Integer,Integer,Double>>();
	
	for (int i =0; i< record.size() -1; i++) {
		if( dv.size() > 0) {
			//get the item with minimum weight
			PrimVex u = 	minByWeight(dv);
			if(record.get(u.v).id < record.get(u.nearest).id) {
				res.add(new Triplet<Integer,Integer,Double>(record.get(u.v).id , record.get(u.nearest).id,u.weight));
			}else {
				res.add(new Triplet<Integer,Integer,Double>(record.get(u.nearest).id,record.get(u.v).id ,u.weight));
			}
			dv.remove(u);
			
			for(PrimVex x : dv) {
				Double d = record.get(x.v).Distance(record.get(u.v));
				if(d < x.weight) {
					x.nearest = u.v;
					x.weight = d;
				}
			}
			
		}	
	}
	return res;
}

public PrimVex minByWeight(ArrayList<PrimVex> listV) {
	Double min = Double.MAX_VALUE;
	int index = -1;
	if(listV.size()>0) {
		
		for(int i =0; i< listV.size(); i++) {
			if (Double.compare(listV.get(i).weight, min) < 0){
				min = listV.get(i).weight;
				index = i;
			}
			
		}
	}
	
	return listV.get(index);
	
}
	
public static void main(String [] args) {
	
	ArrayList<Double>  p1 = new ArrayList<Double>();
	p1.add(1.0);
	p1.add(1.0);
	
	ArrayList<Double>  p2 = new ArrayList<Double>();
	p2.add(2.0);
	p2.add(2.0);
	
	ArrayList<Double>  p3 = new ArrayList<Double>();
	p3.add(3.0);
	p3.add(3.0);
	
	ArrayList<Double>  p4 = new ArrayList<Double>();
	p4.add(5.0);
	p4.add(5.0);
	
	Vector vec1 = new Vector( 1,p1 );
	Vector vec2 = new Vector(2,p2);
	Vector vec3 = new Vector(3,p3);
	Vector vec4 = new Vector(3,p4);
	
	ArrayList<Vector> vectors = new ArrayList<Vector>();
	vectors.add(vec1);
	vectors.add(vec2);
	vectors.add(vec3);
	vectors.add(vec4);
	
	Prims objPrim = new Prims();
	ArrayList<Triplet<Integer,Integer,Double>> res = objPrim.mst(vectors);
	for(int i =0;i< res.size(); i++) {
		System.out.println(res.get(i).getValue0() + "," + res.get(i).getValue1()+ "," +res.get(i).getValue2());
	}
	
	File file = new File("\\Users\\prembhusal\\test.txt"); 
	  
	  BufferedReader br = null;
	try {
		br = new BufferedReader(new FileReader(file));
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} 
	  
	  String st; 
	  try {
		while ((st = br.readLine()) != null) 
		    System.out.println(st);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	  
	
}
}
class PrimVex {
	int v;
	int nearest;
	Double weight;
	PrimVex(int idx, int nearIdx, Double dist){
		this.v = idx;
		this.nearest = nearIdx;
		this.weight = dist;
	}
	
}