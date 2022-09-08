package Cafe_test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CafeIO extends ArrayMemberList {

	// DB에 넣을 파일 주소
	File directFile = new File("C:\\Users\\User\\Desktop\\DBTest\\DBDB.txt");

	// 파일 존재여부 확인 및 생성
	public void readFile() {
		try {
			if (directFile.createNewFile()) {
				System.out.println("파일이 없습니다. 새로 생성합니다.");
			} else {
				System.out.println("파일이 이미 존재합니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 출력 스트림
	public void writeFile(ArrayList<CafeDTO> memberList) {

		try (FileWriter directfw = new FileWriter(directFile, true)) {
			// 저장할 정보들
			for (int i = 0; i < memberList.size(); i++) {
				String writeML = memberList.get(i).getName() + "," + memberList.get(i).getBirthday() + ","
						+ memberList.get(i).getFd() + "," + memberList.get(i).getId() + ","
						+ memberList.get(i).getPassword() + "," + memberList.get(i).getGrade() + ","
						+ memberList.get(i).getPoint() + "\n";

				// 파일로 출력
				directfw.write(writeML);
				directfw.flush();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// 입력 스트림
	public ArrayList<CafeDTO> readReader() {
		memberList.clear();
		try {
			FileReader fileReader = new FileReader(directFile);
			try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
				String str;

				while (true) {
					// 한문장 읽기
					str = bufferedReader.readLine();
					// 읽을 줄 없을 시
					if (str == null) {
						break;
					}

					String[] writeMLar = str.split(",");

					// 테스트용
					// System.out.println(str);

					// 배열 수 불일치 시
					if (writeMLar.length != 7)
						continue;

					CafeDTO cafedto = new CafeDTO();

					// 각 정보 저장
					cafedto.setName(writeMLar[0]);
					System.out.print(cafedto.getName());

					cafedto.setBirthday(writeMLar[1]);
					System.out.print(cafedto.getBirthday());

					cafedto.setFd(writeMLar[2]);
					System.out.print(cafedto.getFd());

					cafedto.setId(writeMLar[3]);
					System.out.print(cafedto.getId());

					cafedto.setPassword(writeMLar[4]);
					System.out.print(cafedto.getPassword());

					cafedto.setGrade(writeMLar[5]);
					System.out.print(cafedto.getGrade());

					cafedto.setPoint(Integer.parseInt(writeMLar[6]));
					System.out.print(cafedto.getPoint());

					memberList.add(cafedto);
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return memberList;
	}

	// 덮어쓰기
	public void overwriteFile() {
		try (FileWriter directfw = new FileWriter(directFile)) {
			// 저장할 정보들
			for (int i = 0; i < memberList.size(); i++) {
				String writeML = memberList.get(i).getName() + "," + memberList.get(i).getBirthday() + ","
						+ memberList.get(i).getFd() + "," + memberList.get(i).getId() + ","
						+ memberList.get(i).getPassword() + "," + memberList.get(i).getGrade() + ","
						+ memberList.get(i).getPoint() + "\n";

				// 파일로 출력
				directfw.write(writeML);
				directfw.flush();
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
