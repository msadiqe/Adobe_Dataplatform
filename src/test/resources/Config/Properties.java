package java.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

public class Properties
  extends Hashtable<Object, Object>
{
  private static final long serialVersionUID = 4112578634029874840L;
  protected Properties defaults;
  private static final char[] hexDigit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
  
  public Properties()
  {
    this(null);
  }
  
  public Properties(Properties paramProperties)
  {
    defaults = paramProperties;
  }
  
  public synchronized Object setProperty(String paramString1, String paramString2)
  {
    return put(paramString1, paramString2);
  }
  
  public synchronized void load(Reader paramReader)
    throws IOException
  {
    load0(new Properties.LineReader(this, paramReader));
  }
  
  public synchronized void load(InputStream paramInputStream)
    throws IOException
  {
    load0(new Properties.LineReader(this, paramInputStream));
  }
  
  private void load0(Properties.LineReader paramLineReader)
    throws IOException
  {
    char[] arrayOfChar = new char['Ѐ'];
    int i;
    while ((i = paramLineReader.readLine()) >= 0)
    {
      int m = 0;
      int j = 0;
      int k = i;
      int n = 0;
      int i1 = 0;
      while (j < i)
      {
        m = lineBuf[j];
        if (((m == 61) || (m == 58)) && (i1 == 0))
        {
          k = j + 1;
          n = 1;
          break;
        }
        if (((m == 32) || (m == 9) || (m == 12)) && (i1 == 0))
        {
          k = j + 1;
          break;
        }
        if (m == 92) {
          i1 = i1 == 0 ? 1 : 0;
        } else {
          i1 = 0;
        }
        j++;
      }
      while (k < i)
      {
        m = lineBuf[k];
        if ((m != 32) && (m != 9) && (m != 12))
        {
          if ((n != 0) || ((m != 61) && (m != 58))) {
            break;
          }
          n = 1;
        }
        k++;
      }
      String str1 = loadConvert(lineBuf, 0, j, arrayOfChar);
      String str2 = loadConvert(lineBuf, k, i - k, arrayOfChar);
      put(str1, str2);
    }
  }
  
  private String loadConvert(char[] paramArrayOfChar1, int paramInt1, int paramInt2, char[] paramArrayOfChar2)
  {
    int i;
    if (paramArrayOfChar2.length < paramInt2)
    {
      i = paramInt2 * 2;
      if (i < 0) {
        i = Integer.MAX_VALUE;
      }
      paramArrayOfChar2 = new char[i];
    }
    char[] arrayOfChar = paramArrayOfChar2;
    int j = 0;
    int k = paramInt1 + paramInt2;
    while (paramInt1 < k)
    {
      i = paramArrayOfChar1[(paramInt1++)];
      if (i == 92)
      {
        i = paramArrayOfChar1[(paramInt1++)];
        if (i == 117)
        {
          int m = 0;
          for (int n = 0; n < 4; n++)
          {
            i = paramArrayOfChar1[(paramInt1++)];
            switch (i)
            {
            case 48: 
            case 49: 
            case 50: 
            case 51: 
            case 52: 
            case 53: 
            case 54: 
            case 55: 
            case 56: 
            case 57: 
              m = (m << 4) + i - 48;
              break;
            case 97: 
            case 98: 
            case 99: 
            case 100: 
            case 101: 
            case 102: 
              m = (m << 4) + 10 + i - 97;
              break;
            case 65: 
            case 66: 
            case 67: 
            case 68: 
            case 69: 
            case 70: 
              m = (m << 4) + 10 + i - 65;
              break;
            case 58: 
            case 59: 
            case 60: 
            case 61: 
            case 62: 
            case 63: 
            case 64: 
            case 71: 
            case 72: 
            case 73: 
            case 74: 
            case 75: 
            case 76: 
            case 77: 
            case 78: 
            case 79: 
            case 80: 
            case 81: 
            case 82: 
            case 83: 
            case 84: 
            case 85: 
            case 86: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 91: 
            case 92: 
            case 93: 
            case 94: 
            case 95: 
            case 96: 
            default: 
              throw new IllegalArgumentException("Malformed \\uxxxx encoding.");
            }
          }
          arrayOfChar[(j++)] = ((char)m);
        }
        else
        {
          if (i == 116) {
            i = 9;
          } else if (i == 114) {
            i = 13;
          } else if (i == 110) {
            i = 10;
          } else if (i == 102) {
            i = 12;
          }
          arrayOfChar[(j++)] = i;
        }
      }
      else
      {
        arrayOfChar[(j++)] = i;
      }
    }
    return new String(arrayOfChar, 0, j);
  }
  
  private String saveConvert(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = paramString.length();
    int j = i * 2;
    if (j < 0) {
      j = Integer.MAX_VALUE;
    }
    StringBuffer localStringBuffer = new StringBuffer(j);
    for (int k = 0; k < i; k++)
    {
      char c = paramString.charAt(k);
      if ((c > '=') && (c < ''))
      {
        if (c == '\\')
        {
          localStringBuffer.append('\\');
          localStringBuffer.append('\\');
        }
        else
        {
          localStringBuffer.append(c);
        }
      }
      else {
        switch (c)
        {
        case ' ': 
          if ((k == 0) || (paramBoolean1)) {
            localStringBuffer.append('\\');
          }
          localStringBuffer.append(' ');
          break;
        case '\t': 
          localStringBuffer.append('\\');
          localStringBuffer.append('t');
          break;
        case '\n': 
          localStringBuffer.append('\\');
          localStringBuffer.append('n');
          break;
        case '\r': 
          localStringBuffer.append('\\');
          localStringBuffer.append('r');
          break;
        case '\f': 
          localStringBuffer.append('\\');
          localStringBuffer.append('f');
          break;
        case '!': 
        case '#': 
        case ':': 
        case '=': 
          localStringBuffer.append('\\');
          localStringBuffer.append(c);
          break;
        default: 
          if ((((c < ' ') || (c > '~')) & paramBoolean2))
          {
            localStringBuffer.append('\\');
            localStringBuffer.append('u');
            localStringBuffer.append(toHex(c >> '\f' & 0xF));
            localStringBuffer.append(toHex(c >> '\b' & 0xF));
            localStringBuffer.append(toHex(c >> '\004' & 0xF));
            localStringBuffer.append(toHex(c & 0xF));
          }
          else
          {
            localStringBuffer.append(c);
          }
          break;
        }
      }
    }
    return localStringBuffer.toString();
  }
  
  private static void writeComments(BufferedWriter paramBufferedWriter, String paramString)
    throws IOException
  {
    paramBufferedWriter.write("#");
    int i = paramString.length();
    int j = 0;
    int k = 0;
    char[] arrayOfChar = new char[6];
    arrayOfChar[0] = '\\';
    arrayOfChar[1] = 'u';
    while (j < i)
    {
      int m = paramString.charAt(j);
      if ((m > 255) || (m == 10) || (m == 13))
      {
        if (k != j) {
          paramBufferedWriter.write(paramString.substring(k, j));
        }
        if (m > 255)
        {
          arrayOfChar[2] = toHex(m >> 12 & 0xF);
          arrayOfChar[3] = toHex(m >> 8 & 0xF);
          arrayOfChar[4] = toHex(m >> 4 & 0xF);
          arrayOfChar[5] = toHex(m & 0xF);
          paramBufferedWriter.write(new String(arrayOfChar));
        }
        else
        {
          paramBufferedWriter.newLine();
          if ((m == 13) && (j != i - 1) && (paramString.charAt(j + 1) == '\n')) {
            j++;
          }
          if ((j == i - 1) || ((paramString.charAt(j + 1) != '#') && (paramString.charAt(j + 1) != '!'))) {
            paramBufferedWriter.write("#");
          }
        }
        k = j + 1;
      }
      j++;
    }
    if (k != j) {
      paramBufferedWriter.write(paramString.substring(k, j));
    }
    paramBufferedWriter.newLine();
  }
  
  @Deprecated
  public void save(OutputStream paramOutputStream, String paramString)
  {
    try
    {
      store(paramOutputStream, paramString);
    }
    catch (IOException localIOException) {}
  }
  
  public void store(Writer paramWriter, String paramString)
    throws IOException
  {
    store0((paramWriter instanceof BufferedWriter) ? (BufferedWriter)paramWriter : new BufferedWriter(paramWriter), paramString, false);
  }
  
  public void store(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    store0(new BufferedWriter(new OutputStreamWriter(paramOutputStream, "8859_1")), paramString, true);
  }
  
  private void store0(BufferedWriter paramBufferedWriter, String paramString, boolean paramBoolean)
    throws IOException
  {
    if (paramString != null) {
      writeComments(paramBufferedWriter, paramString);
    }
    paramBufferedWriter.write("#" + new Date().toString());
    paramBufferedWriter.newLine();
    synchronized (this)
    {
      Enumeration localEnumeration = keys();
      while (localEnumeration.hasMoreElements())
      {
        String str1 = (String)localEnumeration.nextElement();
        String str2 = (String)get(str1);
        str1 = saveConvert(str1, true, paramBoolean);
        str2 = saveConvert(str2, false, paramBoolean);
        paramBufferedWriter.write(str1 + "=" + str2);
        paramBufferedWriter.newLine();
      }
    }
    paramBufferedWriter.flush();
  }
  
  public synchronized void loadFromXML(InputStream paramInputStream)
    throws IOException, InvalidPropertiesFormatException
  {
    Properties.XmlSupport.load(this, (InputStream)Objects.requireNonNull(paramInputStream));
    paramInputStream.close();
  }
  
  public void storeToXML(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    storeToXML(paramOutputStream, paramString, "UTF-8");
  }
  
  public void storeToXML(OutputStream paramOutputStream, String paramString1, String paramString2)
    throws IOException
  {
    Properties.XmlSupport.save(this, (OutputStream)Objects.requireNonNull(paramOutputStream), paramString1, (String)Objects.requireNonNull(paramString2));
  }
  
  public String getProperty(String paramString)
  {
    Object localObject = super.get(paramString);
    String str = (localObject instanceof String) ? (String)localObject : null;
    return (str == null) && (defaults != null) ? defaults.getProperty(paramString) : str;
  }
  
  public String getProperty(String paramString1, String paramString2)
  {
    String str = getProperty(paramString1);
    return str == null ? paramString2 : str;
  }
  
  public Enumeration<?> propertyNames()
  {
    Hashtable localHashtable = new Hashtable();
    enumerate(localHashtable);
    return localHashtable.keys();
  }
  
  public Set<String> stringPropertyNames()
  {
    Hashtable localHashtable = new Hashtable();
    enumerateStringProperties(localHashtable);
    return localHashtable.keySet();
  }
  
  public void list(PrintStream paramPrintStream)
  {
    paramPrintStream.println("-- listing properties --");
    Hashtable localHashtable = new Hashtable();
    enumerate(localHashtable);
    Enumeration localEnumeration = localHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      String str1 = (String)localEnumeration.nextElement();
      String str2 = (String)localHashtable.get(str1);
      if (str2.length() > 40) {
        str2 = str2.substring(0, 37) + "...";
      }
      paramPrintStream.println(str1 + "=" + str2);
    }
  }
  
  public void list(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.println("-- listing properties --");
    Hashtable localHashtable = new Hashtable();
    enumerate(localHashtable);
    Enumeration localEnumeration = localHashtable.keys();
    while (localEnumeration.hasMoreElements())
    {
      String str1 = (String)localEnumeration.nextElement();
      String str2 = (String)localHashtable.get(str1);
      if (str2.length() > 40) {
        str2 = str2.substring(0, 37) + "...";
      }
      paramPrintWriter.println(str1 + "=" + str2);
    }
  }
  
  private synchronized void enumerate(Hashtable<String, Object> paramHashtable)
  {
    if (defaults != null) {
      defaults.enumerate(paramHashtable);
    }
    Enumeration localEnumeration = keys();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      paramHashtable.put(str, get(str));
    }
  }
  
  private synchronized void enumerateStringProperties(Hashtable<String, String> paramHashtable)
  {
    if (defaults != null) {
      defaults.enumerateStringProperties(paramHashtable);
    }
    Enumeration localEnumeration = keys();
    while (localEnumeration.hasMoreElements())
    {
      Object localObject1 = localEnumeration.nextElement();
      Object localObject2 = get(localObject1);
      if (((localObject1 instanceof String)) && ((localObject2 instanceof String))) {
        paramHashtable.put((String)localObject1, (String)localObject2);
      }
    }
  }
  
  private static char toHex(int paramInt)
  {
    return hexDigit[(paramInt & 0xF)];
  }
}
