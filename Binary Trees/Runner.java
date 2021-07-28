
public class Runner
{

   public static void main(String[] args)
   {
      TreeNode test1 = new TreeNode(2, null, null);
      TreeNode test2 = new TreeNode(4, null, null);
      TreeNode test3 = new TreeNode(1, null, test1);
      TreeNode test4 = new TreeNode(5, test2, null);
      TreeNode test5 = new TreeNode(3, test3, test4);
      traverse(test5);
   }
   
   //TRAVERSE() method is HERE
   public static void traverse(TreeNode p)
   {
      if(p != null)
      {
         traverse(p.getLeft());
         System.out.println(p.getValue());  
         traverse(p.getRight());
      }
      
   }
}

class TreeNode
{
	private int value;
	private TreeNode left;
	private TreeNode right;
	public TreeNode(int initValue, TreeNode initLeft, TreeNode initRight)
	{
		value = initValue;
		left = initLeft;
		right = initRight;
	}
	public int getValue()							{ return value; 			}
	public TreeNode getLeft()						{ return left; 				}
	public TreeNode getRight()					{ return right; 			}
	public void setValue(int theNewValue)			{ value = theNewValue; 	}
	public void setLeft(TreeNode theNewLeft)		{ left = theNewLeft; 		}
	public void setRight(TreeNode theNewRight)	{ right = theNewRight; 	}
}