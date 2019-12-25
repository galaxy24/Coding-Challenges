package Kattis;

// Working program using Reader Class 
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.io.IOException;
import java.util.PriorityQueue;

class CheaperDrink {

    class Tuple implements Comparable<Tuple>{

        String stringRep;
        int value;

        public Tuple(String rep, int value){
            this.stringRep = rep;
            this.value = value;
        }

        public int getVal() {return value;}

        @Override
        public String toString() {return stringRep;}

        @Override
        public int compareTo(Tuple that) {
            if (this.value == that.getVal()) return 0;
            else if (this.value > that.getVal()) return 1;
            else return -1;
        }
    }

    public static void main(final String[] args) throws IOException{
        final Reader reader = new Reader();
        final int n = reader.nextInt();
        final PriorityQueue<Tuple> magnets = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++){
            final String line = reader.readLine();
            if (line.contains("2") || line.contains("3") || line.contains("4") || line.contains("5") || line.contains("7")){
                // 0 , 1, and 8 from their upside-down counterpart. Moreover, 6 and 9
                magnets.add(new Tuple(line,Integer.parseInt(line)));
                continue;
            }
            else {
                char[] ch = line.toCharArray();
                StringBuilder rev = new StringBuilder();
                for(int j = ch.length-1 ; j >= 0 ; j--){
                    if (ch[j] == '9') {
                        rev.append('6');
                    } else if (ch[j] == '6'){
                        rev.append('9');
                    } else rev.append(ch[j]);
                }
                Tuple t;
                int orig = Integer.parseInt(line), pot = Integer.parseInt(rev.toString());
                if (pot < orig) {
                    t = new Tuple(rev.toString(), pot);
                } else {
                    t = new Tuple(line, orig);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while(!magnets.isEmpty()){
            res.append(magnets.remove());
        }

        System.out.println(res.toString());
        
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(final String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            final byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            final boolean neg = (c == '-');
            if (neg) 
                c = read(); 
  
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
  
            if (c == '.') 
            { 
                while ((c = read()) >= '0' && c <= '9') 
                { 
                    ret += (c - '0') / (div *= 10); 
                } 
            } 
  
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        private void fillBuffer() throws IOException 
        { 
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
  
        private byte read() throws IOException 
        { 
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
  
        public void close() throws IOException 
        { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }


}