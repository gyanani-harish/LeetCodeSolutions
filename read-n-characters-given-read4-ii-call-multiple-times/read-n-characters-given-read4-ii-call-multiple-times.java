/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class Solution extends Reader4 {
    int read4Pointer = 0;
    int pending = 0;
    char[] read4Buf = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
    
       int totalRead = 0;
        //copy the pending chars we have already read
        for(int i =0;i<pending && i<n;i++){
            totalRead++;
            buf[i]=read4Buf[read4Pointer++];
        }
        int i = pending;
        if (pending > 0) {
            pending = pending - totalRead;
        }
        for (; i < n;) {
            int len = read4(read4Buf);
            if(len == 0){
                //end of file
                break;
            }
            pending = len;
            read4Pointer=0;
            for(int j =0;j<len && i<n;j++){
                totalRead++;
                pending--;
                buf[i++]=read4Buf[read4Pointer++];
            }
        }
        return totalRead;
    }
}