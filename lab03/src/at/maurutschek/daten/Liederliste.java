package at.maurutschek.daten;

public class Liederliste {
	LiederListknoten root;
	
	public Liederliste(LiederListknoten llk) {
		root = llk;
	}
	
	/*
	  	LiederListknoten temp = root;
		while(temp.getNext() != null) {
			//TODO
			temp = temp.getNext();
		}
	 */
	
	
	public Lied vorhanden(Lied l) {
		if(l == null || root == null)return null;
		LiederListknoten temp = root;
		while(temp.getNext() != null) {
			if(temp.getLied().equals(l))return l;
			temp = temp.getNext();
		}
		return null;
	}
	
	public Lied add(Lied l) {
		if(vorhanden(l) != null || l == null)return null;
		if(root == null) root.setNext(new LiederListknoten(l, null));
		LiederListknoten temp = root;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(new LiederListknoten(l, null));
		return l;
	}
	
	public Lied addNachlaenge(Lied l) {
		if(vorhanden(l) != null || l == null)return null;
		if(root == null) root.setNext(new LiederListknoten(l, null));
		if(root.getLied().getLaenge() > l.getLaenge()) {
			root = new LiederListknoten(l, root);
			return l;
		}
		LiederListknoten temp = root;
		while(temp.getNext() != null) {
			if(temp.getNext().getLied().getLaenge() > l.getLaenge()) {
				temp.setNext(new LiederListknoten(l, temp.getNext()));
				return l;
				//TODO nicht getestet!
			}
			temp = temp.getNext();
		}
		temp.setNext(new LiederListknoten(l, null));
		return l;
	}
	
	public Lied del(Lied l) {
		if(vorhanden(l) == null)return null;
		if(root.getLied().equals(l))root = root.getNext();
		LiederListknoten temp = root;
		while(temp.getNext().getNext() != null) {
			if(temp.getNext().getLied().equals(l)) {
				temp.setNext(temp.getNext().getNext());
				return l;
			}
			temp = temp.getNext();
		}
		if(temp.getNext() != null) {
			temp.setNext(null);
		}
		return l;
	}
	
	public int anzLieder() {
		int i = 0;
		LiederListknoten temp = root;
		while(temp.getNext() != null) {
			if(temp.getLied() != null) {
				i++;
			}
			temp = temp.getNext();
		}
		if(temp.getLied() != null) {
			i++;
		}
		return i;
	}
	
	
//	//TODO testen!
//	public void sortByLaenge() {
//		if(root == null)return;
//		LiederListknoten temp = root;
//		Lied
//		while(temp.getNext() != null) {
//			addNachlaenge(temp.getLied());
//			temp = temp.getNext();
//		}
//		addNachlaenge(temp.getLied());
//	}
	
	public void sortByLaenge(){
        boolean sortiert = false;
        while(!sortiert){
            sortiert = true;
            if(root!=null){
                if(root.getNext()!=null && root.getNext().getLied().getLaenge() < root.getLied().getLaenge()) {
                    LiederListknoten temp = root.getNext();
                    root.setNext(temp.getNext());
                    temp.setNext(root); root = temp;
                    sortiert = false;
                    }
                LiederListknoten lauf = root;
                while(lauf.getNext() != null && lauf.getNext().getNext() != null){
                    if(lauf.getNext().getNext().getLied().getLaenge() < root.getLied().getLaenge()){
                        LiederListknoten temp = lauf.getNext().getNext();
                        lauf.getNext().setNext(temp.getNext());
                        temp.setNext(lauf.getNext());
                        lauf.setNext(temp);
                        sortiert = false; 
                        }
                    lauf = lauf.getNext();
                    } 
                } 
            } 
        }
    
    public void sortbyTitel()
    {
        LiederListknoten lauf=root;
        while(lauf!=null && lauf.getNext()!=null && lauf.getNext().getNext()!=null)
        {
            if(lauf.getNext().getLied().getTitel().compareTo(lauf.getNext().getNext().getLied().getTitel())<0)
            {
                LiederListknoten hilf=lauf.getNext();
                lauf.setNext(hilf.getNext());
                hilf.setNext(hilf.getNext().getNext());
                lauf.getNext().setNext(hilf);
            }
            lauf=lauf.getNext();
        }
    }
	
//	public void sortByName(){ //Selectionsort
//		for (int i = 0; i < anzahl - 1; i++) {
//			for (int j = i + 1; j < anzahl; j++) {
//				if (lieder[i].getTitel().compareTo(lieder[j].getTitel()) >= 1) {
//					Lied temp = lieder[i];
//					lieder[i] = lieder[j];
//					lieder[j] = temp;
//				}
//			}
//		}
//	}
}
