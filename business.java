package bai2ck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class business implements quanly {
	private ArrayList <Employee> nhanVien = new ArrayList <> ();
	Scanner sc=new Scanner (System.in);
	
	public void thongtinNV()  {
		int id;
		String name;
		int age;
		String pb;
		System.out.println("Nhap ID: ");
		id=sc.nextInt();
		sc.nextLine();
		checkIDinput(id);
		
		System.out.println("Nhap ten: ");
		name=sc.nextLine();
		checkInput(name);
		System.out.println("Nhap tuoi: ");
		age=sc.nextInt();
		
		checkInput(Integer.toString(age));
		sc.nextLine();
		System.out.println("Nhap phong ban: ");
		pb=sc.nextLine();
		checkInput(pb);
		Employee nv=new Employee(id,name,age,pb);
		nhanVien.add(nv);
		
	}
	public void checkIDinput(int id) {
		if(Integer.toString(id).length()!=6) {
			throw new InputMismatchException("ID phai co 6 ky tu");
		}
	}
	public void checkInput(String in) {
		if(in.length()==0) {
			throw new InputMismatchException("Vui long khong bo trong");
		}
	}
	public void addNV() {
		int n;
		System.out.println("Nhap so nhan vien can them vao");
		n=sc.nextInt();
		if(nhanVien.size()+n<=500) {
			for(int i=0;i<n;i++) {
				thongtinNV();
			}
		}
		
	}
	public void removeNV() {
		System.out.println("Nhap ID can xoa");
		int id=sc.nextInt();
		int index=getIndex(id);
		if(index!=-1) {
			nhanVien.remove(index);
		}
		
	}
	public void sortNV() {
		System.out.println("sap xep theo \n1.ID\n2.phong ban");
		int k=sc.nextInt();
		if(k==1) {
			Collections.sort(nhanVien,new Comparator<Employee>() {

				@Override
				public int compare(Employee o1, Employee o2) {
				
					return o1.getID()-o2.getID();
					
				}
				
			
			});
		}
		else if(k==2) {
			Collections.sort(nhanVien,new Comparator<Employee>() {
				@Override
				public int compare(Employee o1, Employee o2) {
					//System.out.println(o1.getName().compareToIgnoreCase(o2.getName()));
					return o1.getPB().compareToIgnoreCase(o2.getPB());
					
				}
				
			
			});
		}
		
	}
	
	public void change() {
		System.out.println("Nhap ID nhan vien can thay doi");
		int id=sc.nextInt();
		checkIDinput(id);
		int index=getIndex(id);
		if(index==-1) {
			System.out.println("Khong tim thay nhan vien");
		}
		else {
			System.out.println("Nhap new ID");
			id=sc.nextInt();
			sc.nextLine();
			System.out.println("Nhap new name");
			String name=sc.nextLine();
			System.out.println("Nhap new Age");
			int age=sc.nextInt();
			sc.nextLine();
			System.out.println("Nhap new PB");
			String pb=sc.nextLine();
			nhanVien.set(index, new Employee(id,name,age,pb));
		}
	}
	public void print() {
		for(Employee a:nhanVien) {
			System.out.println(a);
		}
	}
	public int getIndex(int id) {
		for(int i=0;i<nhanVien.size();i++) {
			if(nhanVien.get(i).getID()==id) {
				 return i;
			}
		}
		return -1;
	}
	public void menu() {
		int key;
		do {
			System.out.println("MENU");
			System.out.println("1.Nhap Nhan vien");
			System.out.println("2.Xoa Nhan vien");
			System.out.println("3.Sap xep Nhan vien");
			System.out.println("4.In Nhan vien");
			System.out.println("5.Thay doi thong tin");
			key=sc.nextInt();
			switch(key) {
			case 1:
				addNV();
				break;
			case 2:
				removeNV();
				break;
			case 3:
				sortNV();
				break;
			case 4:
				print();
				break;
			case 5:
				change();
				break;
			default:
				
			}
		}while(true);
	}
	
}
