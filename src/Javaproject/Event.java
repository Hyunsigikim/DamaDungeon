package Javaproject;

import java.util.Random;
import java.util.Scanner;

public class Event {
	Random rd = new Random();
	DAMAVO st = new DAMAVO();
	DAMADAO t = new DAMADAO();
	Face fc = new Face();
	Scanner sc = new Scanner(System.in);
	Battle bt = new Battle();
	Sick si = new Sick();

	public void Eventset(String id) { 
		int event_menu = rd.nextInt(100);
		st = t.vo_loding(id);

		if (st.getSickday() == 0) {
			if (event_menu < 5) {
				System.out.println("    ==���� ���� �߻�== ");
				System.out.println("    [1]Ȯ��   [2]�ص� ");
				while (true) {
					int select = sc.nextInt();
					if (select == 1) {
						si.SSick(id);
						break;
					} else if (select == 2) {
						if (st.getHurbs() > 0) {
							System.out.println("==���ʸ� �̿��Ͽ� �ص��Ͽ����ϴ�.==");
							st.setHurbs(st.getHurbs() - 1);
							st.Alldate(id);
							break;
						} else {
							System.out.println("==���ʰ� ���� �ص����� ���߽��ϴ�.==");
							System.out.println("    ==���� �г�Ƽ==");
							si.SSick(id);
							break;
						}
					}
				}
			}
		} else {
			System.out.println("    ==���� �г�Ƽ==");
			si.SSick(id);
		}
		if (event_menu > 90) {
			int select = 0;
			System.out.println("  ==���� ���� �߻�==");
			System.out.println("   [1] ���� ����  ");
			while (select != 1) {
				select = sc.nextInt();
				if (select != 1) {
					System.out.println("  [1] Ȯ���� �� �ּ���  ");
				}
			} 
			int a = rd.nextInt(2)+1;
			bt.Phase(id, a);

		}
	}

}
