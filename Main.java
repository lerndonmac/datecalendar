import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scan = new Scanner(System.in);
        System.out.println("введите дату экзамена dd,MM,yy");

        String dateOfExam = scan.nextLine();
        DateFormat df = new SimpleDateFormat("dd,MM,yy");
        Date colExm = new Date();
        colExm = df.parse(dateOfExam);
        Calendar calendar = new GregorianCalendar();
        obnulyatel(calendar);
        String word  = switchDays(calendar,colExm);
        int count1 = quantity(calendar,colExm);

        System.out.println(switch (colExm.compareTo(calendar.getTime())){
              case 0 -> "Экзамен сегодня";
              case 1->"до экзамена: " + count1 + word;
              case -1 -> "с экзамена прошло: "+ Math.abs(count1) + word;
            default -> "Error";
          });
    }
    public static String switchDays (Calendar firstDate,Date lastDate){
        int count = (int)((lastDate.getTime()-firstDate.getTimeInMillis())/1000/60/60/24);
        int wordcount = count%10;
       String word = switch (wordcount){
            case 1 -> "день";
            case 2,3,4 -> "дня";
           default -> "дней";
        };
       return word;
    }
    public static Calendar obnulyatel (Calendar fistDate){
        fistDate.set(Calendar.HOUR_OF_DAY,0);
        fistDate.set(Calendar.MINUTE,0);
        fistDate.set(Calendar.SECOND,0);
        fistDate.set(Calendar.MILLISECOND,0);
       return fistDate;
    }
    public static int quantity(Calendar fc , Date lc){
        int count = (int)((lc.getTime()-obnulyatel(fc).getTimeInMillis())/1000/60/60/24);
        return count;
    }
}