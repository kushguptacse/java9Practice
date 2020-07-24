package practiceJava9;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

public class ProcessPractice {
	public static void main(String[] args) {
		ProcessHandle ph = ProcessHandle.current();
		System.out.println("current java process id :" + ph.pid());
		Optional<ProcessHandle> optional = ProcessHandle.of(ph.pid());
		ProcessHandle.Info info = optional.get().info();
		System.out.println(info);
		System.out.println("arguments : " + info.arguments());
		System.out.println("command : " + info.command().get());
		System.out.println("start time : " + info.startInstant().get());
		System.out.println("total cpu time : " + info.totalCpuDuration().get());
		System.out.println("user : " + info.user().get());
		// start new process
		ProcessBuilder pb = new ProcessBuilder("notepad.exe",
				"C:\\Users\\g521885\\Downloads\\Dacs.postman_collection (1).json");
		try {
			Process p = pb.start();
			long pidNotepad = p.pid();
			System.out.println(p.toHandle().info());
			System.out.println("current process childs are - ");
			ph.children().forEach(x -> System.out.println(x.pid() + ", " + x.info()));
			Thread.sleep(1500);
			p.destroy();// destroy notepad
			System.out.println("destroyed process : " + pidNotepad);
			ProcessHandle.of(pidNotepad).ifPresentOrElse(i -> System.out.println(i.info()),
					() -> System.out.println("process does not exist with id " + pidNotepad));
			System.out.println("on exit called for process -------------" + p.onExit().get().pid());
			System.out.println("current process childs are - ");
			ph.children().forEach(x -> System.out.println(x.pid() + ", " + x.info()));
		} catch (IOException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		System.out.println("---------");
		ProcessHandle.allProcesses().filter(x -> x.info().user().isPresent()).limit(10)
				.forEach(x -> System.out.println(x.info()));
	}
}
