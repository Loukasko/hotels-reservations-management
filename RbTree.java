package project1;

public class RbTree {
	public static Node root;
	public static int x=100;
	public static int h=1,c=0;
	static int counter=0;
	public RbTree(){
		root=null;
	}
	
	public void restoreRbTree(Node k){
		if (counter<2){
			return;
			
		}
		Node p;
		Node g;
		p=k.getParent();
		g=p.getParent();
		
		if(p.isColor()==true){
			return;
		}
		
		if(p.isColor()==false){
			if(p.getSibling()==null||p.getSibling().isColor()){
				if (p==g.getLeft()){
					if(k==p.getLeft()){
						rotateRight(g);
						p.setColor(true);
						g.setColor(false);
						if(g==root){
							root=p;
						}
					}else if (k==p.getRight()){
						p.setParent(k);
						g.setParent(k);
						k.setLeft(p);
						k.setRight(g);
						k.setColor(true);
						g.setColor(false);
						p.setColor(false);
						if(g==root){
							root=k;
						}
					}
				}else if(p==g.getRight()){
					if(k==p.getRight()){
						rotateLeft(g);
						g.setColor(false);
						p.setColor(true);
						if(g==root){
							root=p;
						}
					}else if (k==p.getLeft()){
						p.setParent(k);
						g.setParent(k);
						k.setLeft(g);
						k.setRight(p);
						k.setColor(true);
						g.setColor(false);
						p.setColor(false);
						if(g==root){
							root=k;
						}
					}
				}
				
			}else if (p.getSibling().isColor()==false){
				if(g!=root){
					g.setColor(false);
				}
				if(g.getRight()!=null){
					g.getRight().setColor(true);
				}
				if(g.getLeft()!=null){
					g.getLeft().setColor(true);
				}
				
			}
		}
		int x=counter;
		while (x>5){
			restoreRbTree(p);
			if(k.getSibling()!=null){
				restoreRbTree(k.getSibling());
			}
			if(p.getSibling()!=null){
				restoreRbTree(p.getSibling());
			}
			restoreRbTree(g);
			x--;
		}
		
	}
	public static void printRbTree(Node p){
		Node ini1,ini2;
		ini1=p.getLeft();
		ini2=p.getRight();
		h=h*2;
		while(x>1){
			for(int i=0;i<x;i++){
				System.out.print(" ");
			}
			System.out.print(p.getKey() +" "+ p.isColor());
			for(int i=0;i<x;i++){
				System.out.print(" ");
			}
			System.out.println();
			x=x/2;
			
			if(c<h/2){
				printRbTree(ini1);
			}else{
				printRbTree(ini2);
			}
		}
	}

	public static Node getRoot() {
		return root;
	}

	public static void setRoot(Node root) {
		RbTree.root = root;
	}

	public void rotateRight(Node g){
		Node p;
		p=g.getLeft();
		if(p.getRight()!=null){
			g.setLeft(p.getRight());
			g.getLeft().setParent(g);
		}else{
			g.setLeft(null);
		}
		if(g.getParent()!=null){
			if(g.getParent().getLeft()==g){
				g.getParent().setLeft(p);
			}else{
				g.getParent().setRight(p);
			}
			p.setParent(g.getParent());

		}
		p.setRight(g);
		g.setParent(p);
		
	}
	
	public void rotateLeft(Node g){
		Node p;
		p=g.getRight();
		if(p.getLeft()!=null){
			g.setRight(p.getLeft());
			g.getRight().setParent(g);
		}else{
			g.setRight(null);
		}
		if(g.getParent()!=null){
			if(g.getParent().getLeft()==g){
				g.getParent().setLeft(p);
			}else{
				g.getParent().setRight(p);
			}
			p.setParent(g.getParent());
		}
		p.setLeft(g);
		g.setParent(p);
	
	}
	
	public void insert(Hotel hotel){
		Node current;
		Node n=new Node(hotel);
		n.setColor(false);
		counter++;
		if(root==null){
			root=n;
			root.setColor(true);
			return;
		}
		
		current=root;
		
		while(true){
			
			if(n.getKey()>current.getKey()){
				
				if(current.getRight()==null){
					current.setRight(n);
					n.setParent(current);
					restoreRbTree(n);
					return;
				}
				current=current.getRight();
			
			}else if(n.getKey()<current.getKey()){
				
				if(current.getLeft()==null){
					current.setLeft(n);
					n.setParent(current);
					restoreRbTree(n);
					return;
				}
				current=current.getLeft();
				
			}
			
		}
	}
	
	public Hotel search(int id){
		
		Node current;
		current=root;
		
		if (root==null){
			System.out.println("No tree is planted");
			return null;
		}
		
		if (root.getKey()==id){
			return root.getHotel();
		}
		
		while(true){
			if(current==null){
				return null;
			}
			if (id<current.getKey()){
				current=current.getLeft();
			}else if(id>current.getKey()){
				current=current.getRight();
			}else if(current.getKey()==id){
				return current.getHotel();
			}
		
		}
		
	}
}
