launch 는 Job객체를 반환한다.
job.join() 기다리게 한다.
job.cancel() 취소. 단, cancel을 쓴다고 모든 job이 종료되는게 아니라서 isActive 사용해서 조건문에 넣고 종료하는게 좋다.
socket 통신 처럼 반드시 종료를 시켜줘야하는 기능을 다룰 때, try catch finally 로 코드 작업 해줘야 한다. finally에 socket 종료 코드 넣는다
어떤 코드는 취소가 불가능해야 하는데 그 때 withContext(NonCancellable)를 사용한다.
어떤 코드는 일정 시간 후에 종료해야 하는데 그 때 withTimeout을 사용한다. withTimeoutOrNull은 일정 시간 후에 종료되거나 Null을 반환한다.
