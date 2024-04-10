import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyLinkedListTest {
	public static void main(String[] args) {
		Employee emp1 = new Employee(101,"Jack",10000);
		Employee emp2 = new Employee(102,"Jane",20000);
		Employee emp3 = new Employee(103,"Jill",30000);
		Employee emp4 = new Employee(104,"John",50000);
		Employee emp5 = new Employee(105,"Johnny",50069);
		
		Employee emp6 = new Employee(106,"Luffy",48596);
		
		MyLinkedList list = new MyLinkedList();
		
		
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.insertBeforeEmployeeNumber(emp5, 102);
		list.addInTheBeginning(emp4);
//		list.deleteNodeInTheBeginning();
//		list.deleteNodeInTheEnd();
//		list.deleteNodeBeforeEmployeeNumber(102);
		list.replaceNode(emp6, 105);
		
		
		int[] arr = {1, 8 , 11 , 898, 456};
		Sort sort = new Sort();
		sort.selectionSort(arr);
		for(int i : arr) {
			System.out.println(i);
		}
		
		
		list.printAll();
		
	}
}

class MyLinkedList
{
	Employee start=null;
	Employee current=null;
	
	void add(Employee node) {
		if(start==null) {
			start = node; //first object
			current = node;
			start.next = null;
			start.prev = null;
		}
		else {
			current.next = node; //2nd object
			node.prev = current;
			current = node;
		}
	}
	
	void printAll() {
		Employee ptr = start;
		while(ptr!=null) {
			System.out.println(ptr.hashCode()+" "+ptr.show());
			ptr = ptr.next;
		}
		
	}
	
	void insertBeforeEmployeeNumber(Employee node, int empNumber) {
        Employee ptr = start;
        while(ptr!=null) {
            if(ptr.getEmpNumber()==empNumber) {
                node.next = ptr;
                node.prev = ptr.prev;
                ptr.prev.next = node;
                ptr.prev = node;
                break;
            }
            ptr = ptr.next;
        }

    }
	
	void addInTheBeginning(Employee node) {
        node.next = start;
        start.prev = node;
        start = node;
        start.prev = null;
        
        try {
            FileOutputStream fileOut = new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(node);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
	}
	
	void deleteNodeInTheBeginning() {
		start = start.next;
        start.prev = null;
	}
	
	void deleteNodeInTheEnd(){
        Employee ptr = start;
        while(ptr.next!=null) {
            ptr = ptr.next;
        }
        ptr.prev.next = null;
    
    }
	
	void deleteNodeBeforeEmployeeNumber(int empNumber) {
        Employee ptr = start;
        while(ptr!=null) {
            if(ptr.getEmpNumber()==empNumber) {
                ptr.prev.prev.next = ptr;
                ptr.prev = ptr.prev.prev;
                break;
            }
            ptr = ptr.next;
        }
    }
	
	void replaceNode(Employee node, int empNumber) {
        Employee ptr = start;
        while(ptr!=null) {
            if(ptr.getEmpNumber()==empNumber) {
                node.next = ptr.next;
                node.prev = ptr.prev;
                ptr.prev.next = node;
                ptr.next.prev = node;
                break;
            }
            
            ptr = ptr.next;
        }
        
    }
	
	
	
}

class Employee implements Serializable
{
	private int empNumber;
	private String empName;
	private float empSalary;
	
	Employee next;
	Employee prev;
	
	public Employee(int empNumber, String empName, float empSalary) {
		super();
		this.empNumber = empNumber;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public int getEmpNumber() {
		return empNumber;
	}

	public void setEmpNumber(int empNumber) {
		this.empNumber = empNumber;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}

	
	public String show() {
		if(this.prev==null )
			return prev+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next.hashCode();
		else
			if(this.next==null)
				return prev.hashCode()+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next;
			else
				return prev.hashCode()+" Employee [empNumber=" + empNumber + ", empName=" + empName + ", empSalary=" + empSalary + "] "+next.hashCode();
					
	}
	
	
}


class Sort{
	void selectionSort(int arr[]){
	    for(int i=0;i<arr.length-1;i++){
	        int min = i;
	        for(int j=i+1;j<arr.length;j++){
	            if(arr[j]<arr[min]){
	                min = j;
	            }
	        }
	        int temp = arr[i];
	        arr[i] = arr[min];
	        arr[min] = temp;
	    }

	}
}