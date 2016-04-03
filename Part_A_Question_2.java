//Devdoot Ghosh
import java.util.Arrays;
import java.util.Scanner;

public class Part_A_Question_2 {

public static void main(String args[]){
	Scanner in=new Scanner(System.in);
	System.out.println("Enter number of students : ");
	int n=in.nextInt();
	student[]ss=new student[n];
	String name="";
	for(int i=0;i<n;i++){
		System.out.printf("Enter Roll number of student %d : ",i+1);
		String rn=in.next();
		in.nextLine();
		System.out.printf("Enter Name of student %d : ",i+1);
		if(in.hasNextLine())
		 name =in.nextLine();
		System.out.printf("Enter Math Score of student %d : ",i+1);
		int  m =in.nextInt();
		System.out.printf("Enter Science Score of student %d : ",i+1);
		int  s =in.nextInt();
		System.out.printf("Enter Environmental Science Score of student %d : ",i+1);
		int  es =in.nextInt();
		System.out.printf("Enter Language 1 Score of student %d : ",i+1);
		in.nextLine();
		int  l1 =in.nextInt();
		System.out.printf("Enter Language 2 Score of student %d : ",i+1);
		int  l2 =in.nextInt();
		ss[i]=new student(name,rn,l1,l2,m,s,es);
		
		
	}
	Arrays.sort(ss);
	for(int i=0;i<n;i++){
		System.out.printf("Rank %d : %s\n",i+1,ss[i].getName());
	}
	
	
}
}
class student implements Comparable{
	//public String Name;
	//Enter Student details: Roll number, Name, Language 1, Language 2, Math, Science, Environmental
	//Science
	private String name;
	private String rn;
	private int l1;
	private int l2;
	private int m;
	private int s;
	private int es;
	private int total;
	//public int l2;
	// Math, Science, ES, Language 1 and Language 2
	public String getName(){
		return name;
	}

	public student(	 String name,String rn,int l1,int l2,int m,int s,int es){
		this.name=name;
		this.rn=rn;
		this.l1=l1;
		this.l2=l2;
		this.es=es;
		this.m=m;
		this.s=s;
		total=l1+l2+es+m+s;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		student t=(student)arg0;
		if(this.total>t.total)return -1;
		else if(this.total<t.total)return 1;
		else{
			if(this.m>t.m)return -1;
			else if(this.m<t.m)return 1;
			else{

				if(this.s>t.s)return -1;
				else if(this.s<t.s)return 1;
				else{

					if(this.es>t.es)return -1;
					else if(this.es<t.es)return 1;
					else{

						if(this.l1>t.l1)return -1;
						else if(this.l1<t.l1)return 1;
						else{

							if(this.l2>t.l2)return -1;
							else if(this.l2<t.l2)return 1;
							else{
								return this.name.compareTo(t.name);}
						}
					}
				}
			}
		}
		//return 0;
	}
}
