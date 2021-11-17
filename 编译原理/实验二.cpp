#include<stdio.h>
#include<stdlib.h>
int num_later,num_data,num_operator,num_separator;//分别表示字母字符数，十进制数字字符数，运算符字符数，分隔符数 
void Count_String(char ch){
	if((ch>='A'&&ch<='Z')||ch>='a'&&ch<='z'){
		num_later++;
	}
	else if(ch>='0'&&ch<='9'){
		num_data++;
	} 
	else if(ch=='+'||ch=='-'||ch=='*'||ch=='|'||ch=='<'||ch=='>'||ch=='='||ch=='#'){
		num_operator++;
	}
	else {
	
		if(ch=='.'||ch==','||ch==';'||ch=='`'||ch=='('||ch==')'||ch=='{'||ch=='}'||ch=='['||ch==']')
		num_separator++;
}
	}
	
	
int main(){
	char ch;
	FILE *fp1,*fp2;
	if((fp1=fopen("C://Users//Phreak//Desktop//test.txt","r"))==NULL){
		printf("file open failed!\n");
		exit(0);
	}//打开文件fp1 
	if((fp2=fopen("C://Users//Phreak//Desktop//counts.txt","w"))==NULL){
		printf("file open failed!\n");
		exit(0);
	}
	while(!feof(fp1)){//从fp1中读取字符，每次只读一个，直到读到文件末尾
     ch=fgetc(fp1);//读字符 
     putchar(ch);
	  Count_String(ch);//统计字符种类
	  fputc(ch,fp2) ;//把读出的字符写入另外一个文件 
		
	}
	// if(!fclose(fp1)){
	// 	printf("\n文件fp1关闭成功\n");
		
	// } 
	// 	if(!fclose(fp2)){
	// 	printf("文件fp2关闭成功\n");
		
	// } 
	printf("num_later=%d,num_data=%d,num_operator=%d,num_separator=%d",num_later,num_data,num_operator,num_separator);
	return 0;
}
