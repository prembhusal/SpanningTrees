package mst;

import java.util.ArrayList;


public  class Vector implements Measurable<Vector>{
	int ID;
	ArrayList<Integer> point;
	Vector(int id, ArrayList<Integer>pt){
		this.ID = id;
		this.point = pt;
	}
	@Override
	public Double Distance(Vector v) {
		Double dist =0.0;
		for( int i=0; i< point.size();i++) {
			dist += Math.pow((point.get(i)-v.point.get(i)),2);
		}
		return Math.sqrt(dist);
	}
	
	
	public static void main(String args[]) {
		ArrayList<Integer>  p1 = new ArrayList<Integer>();
		p1.add(1);
		p1.add(1);
		
		ArrayList<Integer>  p2 = new ArrayList<Integer>();
		p2.add(2);
		p2.add(2);
		
		Vector vec1 = new Vector( 1,p1 );
		Vector vec2 = new Vector(2,p2);
		System.out.println(vec1.Distance(vec2));
	}
}
