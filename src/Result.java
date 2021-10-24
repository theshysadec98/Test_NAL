import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'baCay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY tamnm
     *  2. STRING_ARRAY nghiatt
     *  3. STRING_ARRAY huypq
     *  4. STRING_ARRAY thongnh
     */
    public static int convertGiatriChatBai(char chatBai) {
        int giaTriChatBai = 0;
        if (Character.toString(chatBai).equals("B")) {
            giaTriChatBai = 1;
        } else if (Character.toString(chatBai).equals("T")) {
            giaTriChatBai = 2;
        } else if (Character.toString(chatBai).equals("C")) {
            giaTriChatBai = 3;
        } else {
            giaTriChatBai = 4;
        }
        return giaTriChatBai;
    }


    public static int giaTriChatCaoNhat(char bai1, char bai2, char bai3) {

        int giaTriChatBaiCaoNhat = 0;
        int giaTriChatBai1 = convertGiatriChatBai(bai1);
        int giaTriChatBai2 = convertGiatriChatBai(bai2);
        int giaTriChatBai3 = convertGiatriChatBai(bai3);
        if (giaTriChatBai1 >= giaTriChatBai2 && giaTriChatBai1 >= giaTriChatBai3) {
            giaTriChatBaiCaoNhat = giaTriChatBai1;
        } else if (giaTriChatBai2 >= giaTriChatBai1 && giaTriChatBai2 >= giaTriChatBai3) {
            giaTriChatBaiCaoNhat = giaTriChatBai2;
        } else {
            giaTriChatBaiCaoNhat = giaTriChatBai3;
        }
        return giaTriChatBaiCaoNhat;

    }

    public static int giaTriBaiCaoNhatOfChatCaoNhat(String bai1, String bai2, String bai3) {
        int giaTriChatBaiCaoNhat = 0;
        int giaTriChatBai1 = convertGiatriChatBai(bai1.charAt(1));
        int giaTriChatBai2 = convertGiatriChatBai(bai2.charAt(1));
        int giaTriChatBai3 = convertGiatriChatBai(bai3.charAt(1));
        if (giaTriChatBai1 > giaTriChatBai2) {
            if (giaTriChatBai1 > giaTriChatBai3) {
                int giaTriBai1 = Integer.parseInt(String.valueOf(bai1.charAt(0)));
                giaTriChatBaiCaoNhat = giaTriBai1;
            } else if (giaTriChatBai1 == giaTriChatBai3) {
                int giaTriBai1 = Integer.parseInt(String.valueOf(bai1.charAt(0)));
                int giaTriBai3 = Integer.parseInt(String.valueOf(bai3.charAt(0)));
                if (giaTriBai1 > giaTriBai3) {
                    giaTriChatBaiCaoNhat = giaTriBai1;
                } else giaTriChatBaiCaoNhat = giaTriBai3;
            }
        }
        if (giaTriChatBai2 > giaTriChatBai3) {
            if (giaTriChatBai2 > giaTriChatBai1) {
                int giaTriBai2 = Integer.parseInt(String.valueOf(bai2.charAt(0)));
                giaTriChatBaiCaoNhat = giaTriBai2;
            } else if (giaTriChatBai2 == giaTriChatBai1) {
                int giaTriBai2 = Integer.parseInt(String.valueOf(bai2.charAt(0)));
                int giaTriBai1 = Integer.parseInt(String.valueOf(bai1.charAt(0)));
                if (giaTriBai2 > giaTriBai1) {
                    giaTriChatBaiCaoNhat = giaTriBai2;
                } else giaTriChatBaiCaoNhat = giaTriBai1;
            }
        }
        if (giaTriChatBai3 > giaTriChatBai1) {
            if (giaTriChatBai3 > giaTriChatBai2) {
                int giaTriBai3 = Integer.parseInt(String.valueOf(bai3.charAt(0)));
                giaTriChatBaiCaoNhat = giaTriBai3;
            } else if (giaTriChatBai3 == giaTriChatBai2) {
                int giaTriBai3 = Integer.parseInt(String.valueOf(bai3.charAt(0)));
                int giaTriBai2 = Integer.parseInt(String.valueOf(bai2.charAt(0)));
                if (giaTriBai3 > giaTriBai2) {
                    giaTriChatBaiCaoNhat = giaTriBai3;
                } else giaTriChatBaiCaoNhat = giaTriBai2;
            }
        }
        if (giaTriChatBai1 == giaTriChatBai2 && giaTriChatBai1 == giaTriChatBai3) {
            int giaTriBai1 = Integer.parseInt(String.valueOf(bai1.charAt(0)));
            int giaTriBai2 = Integer.parseInt(String.valueOf(bai2.charAt(0)));
            int giaTriBai3 = Integer.parseInt(String.valueOf(bai3.charAt(0)));

            if (giaTriBai1 > giaTriBai2) {
                if (giaTriBai1 > giaTriBai3) {
                    giaTriChatBaiCaoNhat = giaTriChatBai1;
                } else giaTriChatBaiCaoNhat = giaTriBai3;
            } else {
                if (giaTriBai2 > giaTriChatBai3) {
                    giaTriChatBaiCaoNhat = giaTriBai2;
                } else giaTriChatBaiCaoNhat = giaTriBai3;
            }
        }
        return giaTriChatBaiCaoNhat;
    }


    public static String convertNumberToName(int number) {
        String name = "";
        if (number == 0) {
            name = "TamNM";
        } else if (number == 1) {
            name = "NghiaTT";
        } else if (number == 2) {
            name = "HuyPQ";
        } else {
            name = "ThongNH";
        }
        return name;
    }

    public static String baCay(List<String> tamnm, List<String> nghiatt, List<String> huypq, List<String> thongnh) {
        String result = "";
        int totalTamnm = 0;
        int totalNghiatt = 0;
        int totalHuypq = 0;
        int totalThongnh = 0;

        int giaTriChatCaoNhatTamnm = 0;
        int giaTriChatCaoNhatNghiatt = 0;
        int giaTriChatCaoNhatHuypq = 0;
        int giaTriChatCaoNhatThongnh = 0;

        int giaTriBaiCaoNhatOfChatCaoNhatTamnm = 0;
        int giaTriBaiCaoNhatOfChatCaoNhatNghiatt = 0;
        int giaTriBaiCaoNhatOfChatCaoNhatHuypq = 0;
        int giaTriBaiCaoNhatOfChatCaoNhatThongnh = 0;

        for (int i = 0; i < 3; i++) {
            totalTamnm += Integer.parseInt(String.valueOf(tamnm.get(i).charAt(0)));
            totalNghiatt += Integer.parseInt(String.valueOf(nghiatt.get(i).charAt(0)));
            totalHuypq += Integer.parseInt(String.valueOf(huypq.get(i).charAt(0)));
            totalThongnh += Integer.parseInt(String.valueOf(thongnh.get(i).charAt(0)));
        }
        if (totalTamnm > 10) {
            totalTamnm = totalTamnm % 10;
            if (totalTamnm == 0) {
                totalTamnm = 10;
            }
        }
        if (totalNghiatt > 10) {
            totalNghiatt = totalNghiatt % 10;
            if (totalNghiatt == 0) {
                totalNghiatt = 10;
            }
        }
        if (totalHuypq > 10) {
            totalHuypq = totalHuypq % 10;
            if (totalHuypq == 0) {
                totalHuypq = 10;
            }
        }
        if (totalThongnh > 10) {
            totalThongnh = totalThongnh % 10;
            if (totalThongnh == 0) {
                totalThongnh = 10;
            }
        }
//List diem cua 4 nguoi
        ArrayList<Integer> total = new ArrayList();
        total.add(totalTamnm);
        total.add(totalNghiatt);
        total.add(totalHuypq);
        total.add(totalThongnh);
// List gia tri chat cao nhat cua 4 nguoi
        giaTriChatCaoNhatTamnm = giaTriChatCaoNhat(tamnm.get(0).charAt(1), tamnm.get(1).charAt(1), tamnm.get(2).charAt(1));
        giaTriChatCaoNhatNghiatt = giaTriChatCaoNhat(nghiatt.get(0).charAt(1), nghiatt.get(1).charAt(1), nghiatt.get(2).charAt(1));
        giaTriChatCaoNhatHuypq = giaTriChatCaoNhat(huypq.get(0).charAt(1), huypq.get(1).charAt(1), huypq.get(2).charAt(1));
        giaTriChatCaoNhatThongnh = giaTriChatCaoNhat(thongnh.get(0).charAt(1), thongnh.get(1).charAt(1), thongnh.get(2).charAt(1));

        ArrayList<Integer> giaTriChatCaoNhat = new ArrayList<>();
        giaTriChatCaoNhat.add(giaTriChatCaoNhatTamnm);
        giaTriChatCaoNhat.add(giaTriChatCaoNhatNghiatt);
        giaTriChatCaoNhat.add(giaTriChatCaoNhatHuypq);
        giaTriChatCaoNhat.add(giaTriChatCaoNhatThongnh);

// List gia tri bai cao nhat ma co chat cao nhat cua 4 nguoi
        giaTriBaiCaoNhatOfChatCaoNhatTamnm = giaTriBaiCaoNhatOfChatCaoNhat(tamnm.get(0), tamnm.get(1), tamnm.get(2));
        giaTriBaiCaoNhatOfChatCaoNhatNghiatt = giaTriBaiCaoNhatOfChatCaoNhat(nghiatt.get(0), nghiatt.get(1), nghiatt.get(2));
        giaTriBaiCaoNhatOfChatCaoNhatHuypq = giaTriBaiCaoNhatOfChatCaoNhat(huypq.get(0), huypq.get(1), huypq.get(2));
        giaTriBaiCaoNhatOfChatCaoNhatThongnh = giaTriBaiCaoNhatOfChatCaoNhat(thongnh.get(0), thongnh.get(1), thongnh.get(2));

        ArrayList<Integer> giaTriCaoNhatOfChatCaoNhat = new ArrayList<>();
        giaTriCaoNhatOfChatCaoNhat.add(giaTriBaiCaoNhatOfChatCaoNhatTamnm);
        giaTriCaoNhatOfChatCaoNhat.add(giaTriBaiCaoNhatOfChatCaoNhatNghiatt);
        giaTriCaoNhatOfChatCaoNhat.add(giaTriBaiCaoNhatOfChatCaoNhatHuypq);
        giaTriCaoNhatOfChatCaoNhat.add(giaTriBaiCaoNhatOfChatCaoNhatThongnh);

        //giai quyet
        int maxTotal = 0;
        ArrayList<Integer> indexsTotal = new ArrayList<>();
        for (int i = 0; i < total.size(); i++) {
            if (total.get(i) > maxTotal) {
                maxTotal = total.get(i);
            }
        }
        for (int i = 0; i < total.size(); i++) {
            if (total.get(i) == maxTotal) {
                indexsTotal.add(i);
            }
        }
        if (indexsTotal.size() <= 1) {
            result = convertNumberToName(indexsTotal.get(0));
        } else {
            int maxChatBai = 0;
            ArrayList<Integer> indexsMaxChatBai = new ArrayList<>();
            for (int i = 0; i < indexsTotal.size(); i++) {
                if (giaTriChatCaoNhat.get(indexsTotal.get(i)) > maxChatBai) {
                    maxChatBai = giaTriChatCaoNhat.get(indexsTotal.get(i));
                }
            }
            for (int i = 0; i < indexsTotal.size(); i++) {
                if (giaTriChatCaoNhat.get(indexsTotal.get(i)) == maxChatBai) {
                    indexsMaxChatBai.add(indexsTotal.get(i));
                }
            }
            if (indexsMaxChatBai.size() == 1) {
                result = convertNumberToName(indexsMaxChatBai.get(0));
            } else {
                int maxGiaTriBaiOfMaxChatBai = 0;
                int indexsGiaTriBaiOfMaxChatBai = 0;
                for (int i = 0; i < indexsMaxChatBai.size(); i++) {
                    if (giaTriCaoNhatOfChatCaoNhat.get(indexsMaxChatBai.get(i)) == 1) {
                        indexsGiaTriBaiOfMaxChatBai = indexsMaxChatBai.get(i);
                    } else if (giaTriCaoNhatOfChatCaoNhat.get(indexsMaxChatBai.get(i)) > maxGiaTriBaiOfMaxChatBai) {
                        maxGiaTriBaiOfMaxChatBai = giaTriCaoNhatOfChatCaoNhat.get(indexsMaxChatBai.get(i));
                        indexsGiaTriBaiOfMaxChatBai = indexsMaxChatBai.get(i);
                    }
                }
                result = convertNumberToName(indexsGiaTriBaiOfMaxChatBai);

            }
        }

        return result;
    }

}

