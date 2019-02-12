package mst;

public class Sequence implements Measurable<Sequence>{
	int ID;
	String label;
	String seq;
	Sequence(int seqId, String seqLab, String sequence){
		this.ID = seqId;
		this.label = seqLab;
		this.seq = sequence;
	}
	@Override
	public Double Distance(Sequence m) {
		return HammingDist(seq,m.seq);
	}

	public Double HammingDist(String str1, String str2) {
		if(str1.length()!= str2.length()) {
			return -1.0;
		}
		Double dist =0.0;
		for (int i =0; i< str1.length();i++) {
			if (str1.charAt(i)!=str2.charAt(i)) {
				dist +=1;
			}
		}

		return dist;
	}
	
	public static void main(String [] args) {
		Sequence seq1 = new Sequence(1,"seq1", "ACTT");
		Sequence seq2 = new Sequence(2,"seq2", "ACGG");
		System.out.println(seq1.Distance(seq2));
		
	}
}

