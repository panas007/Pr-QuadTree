import java.lang.Math;


public class Qtree {
	
	Qnode n;     // n is the root of the PR quadtree
	int level;

	 
	public Qtree(int xmin,int ymin,int xmax,int ymax) {

		n  = new Qnode(xmin,ymin,xmax,ymax);
		n.setLeaf(false);
		n.x=-1;
		n.y=-1;
	}
	
	/**
	 *  We devide the rectangle that contain the current node.
	 * @param n The node n to be devided
	 */
	public void devideRect(Qnode n)
	 {
		n.NW = new Qnode(n.Xmin, n.Ymin, (n.Xmin+n.Xmax)/2,(n.Ymin+n.Ymax)/2 );//done
		
		n.SW = new Qnode( n.Xmin, (n.Ymin+n.Ymax)/2,(n.Xmin+n.Xmax)/2,n.Ymax );//done
		
        n.NE = new Qnode((n.Xmin+n.Xmax)/2, n.Ymin, n.Xmax,(n.Ymin+n.Ymax)/2 );//done
        
		n.SE = new Qnode((n.Xmin+n.Xmax)/2, (n.Ymin+n.Ymax)/2, n.Xmax,n.Ymax );//done
		

	 }
	/*Wrapper method for inserting with only x,y parameters
	 * 
	 */
	public void insert(int x,int y) { 

		
       insert(n, x , y); 


	} 
	/**
	 * Recursion method for inserting nodes in the pr quad-tree
	 * First check if x,y values is in the boundary of the current node and the current node is a leaf
	 * if its true then insert the node,else devide the rectangle in SW, SE, NW, NE move the value of the node in the correct subtree  
	 * and move in the next recursion for inserting
	 * 
	 * 
	 * @param node The node to be iserted
	 * @param x 
	 * @param y
	 */
	public void insert(Qnode node,int x,int y)
	{
	   

	        if (inBoundary(x,y,node)==true && leaf(node)==true) {
	        	node.setX(x);
	        	node.setY(y);
	        	node.setLeaf(false);
	        	return ;  
	        }
	        else 
			{
	        	if(node.divided==false && inBoundary(x,y,node)==true) {
	        		this.devideRect(node);
	        		node.divided= true;
	        		
	        		if(node.x !=-1 && node.y!=-1 && leaf(node)==false) {
	        		 if(inBoundary(node.x,node.y,node.NE))
	     	        	{
	        			node.NE.x=node.x;
	        			node.NE.y=node.y;
	     	        	node.x=-1;
	    	        	node.y=-1;
	    	        	node.NE.leaf=false;
	     	        	}
	     	        
	     	        else if(inBoundary(node.x,node.y,node.NW))
	     	        	{
	        			node.NW.x=node.x;
	        			node.NW.y=node.y;
	     	        	node.x=-1;
	    	        	node.y=-1;
	    	        	node.NW.leaf=false;
	     	        	}
	     			
	     	        else if(inBoundary(node.x,node.y,node.SW))
	     	        	{
	        			node.SW.x=node.x;
	        			node.SW.y=node.y;
	     	        	node.x=-1;
	    	        	node.y=-1;
	    	        	node.SW.leaf=false;
	     	        	}
	     			
	     	        else if(inBoundary(node.x,node.y,node.SE))
	     	        	{
	        			node.SE.x=node.x;
	        			node.SE.y=node.y;
	     	        	node.x=-1;
	    	        	node.y=-1;
	    	        	node.SE.leaf=false;
	     	        	}
	        		}
	        	}
			}

	        
	        if(inBoundary(x,y,node.NE))
	        	insert(node.NE,x,y);
	        
	        else if(inBoundary(x,y,node.NW))
	        	insert(node.NW,x,y);
			
	        else if(inBoundary(x,y,node.SE))
	        	insert(node.SE,x,y);
			
	        else if(inBoundary(x,y,node.SW))
	        	insert(node.SW,x,y);
			
			return ;

	}
	
	/**
	 * Check if node is leaf or inner node.
	 * @param node
	 * @return true if node is leaf, if false node is inner node.
	 */
	public boolean isLeaf(Qnode node)
	{
		if((node.SW == null) && (node.NE == null) && (node.NW == null )&& (node.SE == null) )
			return true;
		return false;
	}
	/**
	 * Wrapper method for searching with x,y parameters only
	 * 
	 */
	public Qnode search(int x,int y) { 

		level=0;
		Qnode ni =  search(n, x , y); 
		return ni;
		
	       
	    }
	/**
	 * Search for x,y values
	 * If x,y values exist then return the current node 
	 * else return null
	 */
	public Qnode search(Qnode node,int x,int y) 
	{ 
		
		if(node==null)
			 return null;
		
		
		 if (inBoundary(x,y,node)==true) {
	        	if(node.x==x && node.y==y)
	        	
	        	return node;  
	        }
		 else
			 return null;
		 
		 
	        if(node.NE!= null && inBoundary(x,y,node.NE))
	        {
	        	level++;
	        	return search(node.NE,x,y);
	        }
	        
	        else if(node.NW!= null && inBoundary(x,y,node.NW))
	        {
	        	level++;
	        	return search(node.NW,x,y);
	        }
			
	        else if(node.SE!= null && inBoundary(x,y,node.SE))
	        {
	        	level++;
	        	return search(node.SE,x,y);
	        }
			
	        else if(node.SW!= null &&inBoundary(x,y,node.SW))
	        {
	        	level++;
	        	return search(node.SW,x,y);
	        }
	        else 
	        	return null;

	        			

	}

	/**
	 * Method for check if x,y values can be in the current node
	 *
	 */
	public boolean inBoundary(int x,int y,Qnode n ) 
	{ 
	    return (x >= n.Xmin && 
	        x <= n.Xmax && 
	        y >= n.Ymin && 
	        y <= n.Ymax); 
	}

	public Qnode getN() {
		return n;
	}

	public void setN(Qnode n) {
		this.n = n;
	}




	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public boolean leaf(Qnode node)
	{
		if(node.isLeaf())
			return true;
			return false;
	}
	
	
}
