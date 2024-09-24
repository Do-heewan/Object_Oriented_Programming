package ch03;

public class week3_7 {
	public static void main(String[] args) {
        // 명령행 인자가 없는 경우 메시지 출력 후 종료
        if (args.length == 0) {
            System.out.println("정수를 하나 이상 입력하세요.");
            return;
        }

        int sum = 0;
        int count = args.length;

        // 명령행 인자로 받은 문자열을 정수로 변환하여 합계 계산
        try {
            for (String arg : args) {
                sum += Integer.parseInt(arg);
            }

            // 평균 계산
            double average = (double) sum / count;
            System.out.println("평균: " + average);

        } catch (NumberFormatException e) {
            System.out.println("유효하지 않은 정수가 포함되어 있습니다.");
        }
    }
}
