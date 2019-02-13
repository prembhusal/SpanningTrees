package mst;

import java.util.ArrayList;


public  class Vector {
	int id;
	ArrayList<Double> point;
	Vector(int ID, ArrayList<Double>pt){
		this.id = ID;
		this.point = pt;
	}
	/*public Double Distance(Vector<T> v) {
		Double dist =0.0;
		for( int i=0; i< point.size();i++) {
			Double t = point.get(i) - v.point.get(i);
			dist += t*t;
		}
		return Math.sqrt(dist);
	}*/
	
	
	public static void main(String args[]) {
		ArrayList<Double>  p1 = new ArrayList<Double>();
		p1.add(1.0);
		p1.add(1.0);
		
		ArrayList<Double>  p2 = new ArrayList<Double>();
		p2.add(2.0);
		p2.add(2.0);
		
		Vector vec1 = new Vector( 1,p1 );
		Vector vec2 = new Vector(2,p2);
		System.out.println(vec1.Distance(vec2));
	}
	
	/*@Override
	public Double Distance(Vector m) {
		Double dist =0.0;
		for( int i=0; i< point.size();i++) {
			Double t = point.get(i).doubleValue() - m.point.get(i).doubleValue();
			dist += t*t;
		}
		return Math.sqrt(dist);
	}
	*/

	public Double Distance(Vector m) {
		Double dist =0.0;
		for( int i=0; i< point.size();i++) {
			Double t = point.get(i).doubleValue() - m.point.get(i).doubleValue();
			dist += t*t;
		}
		return Math.sqrt(dist);
	}
}
