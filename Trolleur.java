public class Trolleur extends Personnage
{
	static private int nbTrolleur = 3;
	
	Trolleur (int x, int y, int z, int w)
	{
		super(x,y,z,w);
	}
	// ajouter les classes move (), shoot (), position baseHasard
	
	public String toString ()
	{
		return "@";
	}

	public void shot (Balle balle)
	{
		if ((this.p.getX() == balle.p.getX())&&(this.p.getY() == balle.p.getY()))
		{
			balle.d.setZ(this.d.getZ());
			balle.d.setW(this.d.getW());

		}
	}

	public void move (Terrain t, int verifAJoue,Balle balle)
	{
		if (aJoue != verifAJoue)
		{
			aJoue++;
			int has = (int)( Math.random()*((1) - 0 + 1 ) ) + 0;
			if (has == 1)
			{
				//mouvement
				int x = p.getX();
				int y = p.getY();
				int newX = p.getX()+d.getZ();
				int newY = p.getY()+d.getW();
				if (((newX != t.getLigne()-1)&&(newX != 0)&&(newY != t.getColonne()-1)&&(newY != 0))&&(t.getElementGrille(newX,newY) == null))
				{
					t.setElementGrille(newX,newY, this);
					t.setElementGrille(x,y, null);
					p.setX(newX);
					p.setY(newY);
				}
				else
				{
					d.setZ((int)( Math.random()*((2) - 0 + 1 ) ) -1);
					d.setW((int)( Math.random()*((2) - 0 + 1 ) ) -1);
				}
			}
			else
			{
				//direction
				d.setZ((int)( Math.random()*((2) - 0 + 1 ) ) -1);
				d.setW((int)( Math.random()*((2) - 0 + 1 ) ) -1);
			}
			this.shot(balle);
		}
	}
	
	// fonction get()
	static int getNbTrolleur ()
	{
		return nbTrolleur;
	}
}
