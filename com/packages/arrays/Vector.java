package com.packages.arrays;

public class Vector 
{
    private final int T = 100;
    private int n;
    private int vec[] = new int[T];

    public Vector()
    {
        n = 0;
    }

    public int getT()
    {
        return T;
    }

    public int getN() 
    {
        return n;
    }

    public void setN(int n) 
    {
        this.n = n;
    }

    public int[] getVec() 
    {
        return vec;
    }

    public void setVec(int[] vec) 
    {
        this.vec = vec;
    }

    public void addVector(int datum)
    {
        vec[n] = datum;
        n++;
    }

    public void showVector()
    {
        for (int i = 0; i < n; i++) {
            System.out.print(vec[i] + " | ");
        }
    }


    public int searchSecuencial(int datum)
    {
        int i, pos;
        i = 0;
        pos = -1;
        while (i < n && pos == -1) {
            if (vec[i] == datum) {
                pos = i;
            } else {
                i++;
            }
        }
        return pos;
    }

    public void updateVector(int datum, int pos)
    {
        vec[pos] = datum;
    }

    public void deleteVector(int pos)
    {
        for (int i = pos; i < n - 1; i++) {
            vec[i] = vec[i + 1];
        }
        n--;
    }

    public void insertVector(int pos, int datum)
    {
        for (int i = n; i > pos; i--) {
            vec[i] = vec[i - 1];
        }
        vec[pos] = datum;
        n++;
    }


    public void sortBubble()
    {
        int aux;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (vec[i] > vec[j]) {
                    aux = vec[i];
                    vec[i] = vec[j];
                    vec[j] = aux;
                }
            }
        }
    }

    public int sumVector()
    {
        int s = 0;
        for (int i = 0; i < n; i++) {
            s = s + vec[i];
        }
        return s;
    }

    public int productVector()
    {
        int p = 1;
        for (int i = 0; i < n; i++) {
            p = p * vec[i];
        }
        return p;
    }

    public double avgVector()
    {
        return sumVector() / n;
    }

    public int maxVector()
    {
        int i, m;
        m = vec[0]; // Supuesto: el mayor elemento está en la primera posición
        for (i = 1; i < n; i++) {
            if (vec[i] > m) {
                m = vec[i];
            }
        }
        return m;
    }

    public int minVector()
    {
        int i, m;
        m = vec[0]; // Supuesto: el menor elemento está en la primera posición
        for (i = 1; i < n; i++) {
            if (vec[i] < m) {
                m = vec[i];
            }
        }
        return m;
    }

    public int totalOddPositionEven()
    {
        int i, c;
        c = 0;
        for (i = 0; i < n; i += 2) {
            if (vec[i] % 2 == 1) {
                c++;
            }
        }
        return c;
    }

    public double variance()
    {
        double s = 0;
        for (int i = 0; i < n; i++) {
            s = s + Math.pow(vec[i] - avgVector(), 2);
        }
        return s / (n - 1);
    }

    public double desviation()
    {
        return Math.sqrt(variance());
    }

    public void interchange()
    {
        int aux;
        for (int i = 0; i < n / 2; i++) {
            aux = vec[i];
            vec[i] = vec[n - i - 1];
            vec[n - i - 1] = aux;
        }
    }

    public int productPoint(int [] v1, int [] v2, int t)
    {
        int s = 0;
        for (int i = 0; i < t; i++) {
            s += v1[i] * v2[i];
        }
        return s;
    }

    public void deleteOcurrencies()
    {
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            while (j < n) {
                if (vec[i] == vec[j]) {
                    deleteVector(j);
                } else {
                    j++;
                }
            }
        }
    }

    public boolean sortAsc()
    {
        int i = 0;
        boolean sw = true; // Supuesto: vector ordenado
        while (i < n - 1 && sw) {
            if (vec[i] > vec[i + 1]) {
                sw = false;
            } else {
                i++;
            }
        }
        return sw;
    }
       
    
}
