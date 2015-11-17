//주제: 반복문 for		
package step03

//1) 기본 for문
for (int i = 0; i < 5; i++) 
	println i
println "------------"

//2) 
for (i in 0..4)
	println i
println "------------"

//3) 리스트가 올수 있다
for (i in ["홍길동","임꺽정","유관순"])
	println i
println "------------"

//4) map도 올수 있다.
for (entry in ["이름":"홍길동", "국어":100, "수학":90, "역사":100])
	println entry.key + "=" + entry.value
println "------------"

for (i in ["이름":"홍길동", "국어":100, "수학":90, "역사":100])
println i.key + "=" + i.value
println "------------"
