package project1;

public class Node {
	private boolean color;
	private Hotel hotel;
	private int key;
	private Node right;
	private Node left;
	private Node parent;
	
	public Node(Hotel hotel) {
		this.hotel = hotel;
		this.key = hotel.getId();;
		this.parent = null;
		this.right=null;
		this.left=null;
		this.color=false;
	}
	public boolean isColor() {
		return color;
	}
	public void setColor(boolean color) {
		this.color = color;
	}
	public Hotel getHotel() {
		return hotel;
	}
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public Node getSibling(){
		if(this.getParent().getRight()==null||this.getParent().getLeft()==null){
			return null;
		}
		if (this.getParent().getRight()==this){
			return this.getParent().getLeft();
		}else if (this.getParent().getLeft()==this){
			return this.getParent().getRight();
		}
		return null;
	}
		
}
	
	
