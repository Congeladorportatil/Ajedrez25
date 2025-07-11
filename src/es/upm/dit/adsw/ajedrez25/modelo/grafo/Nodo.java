package es.upm.dit.adsw.ajedrez25.modelo.grafo;

import es.upm.dit.adsw.ajedrez25.modelo.Tablero;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Nodo {
    private Tablero tablero;
    private Set<Enlace> enlaces = new HashSet<>();

    public Nodo(Tablero tablero) {
        this.tablero = tablero;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Set<Enlace> getEnlaces() {
        return enlaces;
    }

    public Set<Enlace> getEnlacesSalientes() {
        Set<Enlace> enlacesSalientes = new HashSet<>();
        for (Enlace enlace : enlaces) {
            if (enlace.getOrigen().equals(this)) {
                enlacesSalientes.add(enlace);
            }
        }
        return enlacesSalientes;
    }

    public Set<Enlace> getEnlacesEntrantes() {
        Set<Enlace> enlacesEntrantes = new HashSet<>();
        for (Enlace enlace : enlaces) {
            if (enlace.getDestino().equals(this)) {
                enlacesEntrantes.add(enlace);
            }
        }
        return enlacesEntrantes;
    }

    public Enlace addEnlaceA(Nodo destino) {
        for (Enlace enlace : enlaces) {
            if (enlace.getDestino().equals(destino)) {
                enlace.incrementarPeso();
                return enlace;
            }
        }
        Enlace e = new Enlace(this, destino);
        enlaces.add(e);
        return e;
    }
    
    public void addEnlace(Enlace e) {
    	if (e.getOrigen().equals(this) || e.getDestino().equals(this))
    		enlaces.add(e);
    }

    public int getGradoEntrada() {
        return getEnlacesEntrantes().size();
    }

    public int getGradoSalida() {
        return getEnlacesSalientes().size();
    }

    public int getGradoEntradaPonderado() {
        int gradoEntradaPonderado = 0;
        for (Enlace enlace : getEnlacesEntrantes()) {
            gradoEntradaPonderado += enlace.getPeso();
        }
        return gradoEntradaPonderado;
    }

    public int getGradoSalidaPonderado() {
        int gradoSalidaPonderado = 0;
        for (Enlace enlace : getEnlacesSalientes()) {
            gradoSalidaPonderado += enlace.getPeso();
        }
        return gradoSalidaPonderado;
    }

	@Override
	public String toString() {
		return "Nodo [tablero=" + tablero +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(tablero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nodo other = (Nodo) obj;
		return Objects.equals(tablero, other.tablero);
	}
    
	
    
}
