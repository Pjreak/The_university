#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

char stayWord[13][15] = {"const", "var", "procedure", "begin", "end", "odd", "if", "then", "call", "while", "do", "read", "write"};
char enumStayWord[13][15] = {"constsym", "varsym", "proceduresym", "beginsym", "endsym", "oddsym", "ifsym", "thensym",
                             "callsym", "whilesym", "dosym", "readsym", "writesym"};
bool isNumber(char ch);
bool isCase(char ch);
bool isCaculationSymbol(char ch);
bool isBandSymbol(char ch);
int isStayWord(char *str);
void getInputStreamFromFile(char *fileName, char *str);
void calulationString(char *str);
void bandString(char *str);
void Analysis(char *InputFileName, char *str);

int main()
{
    char strr[100000], input[100] = "E:\\study\\编译原理\\Examples\\sample2.pl0";
    Analysis(input, strr);
    getchar();
    return 0;
}

bool isNumber(char ch)
{
    if (ch >= '0' && ch <= '9')
        return true;
    return false;
}

bool isCase(char ch)
{
    if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'))
        return true;
    return false;
}

bool isCaculationSymbol(char ch)
{
    if (ch == '+' || ch == '-' || ch == '/' || ch == '>' || ch == '<' || ch == '=' || ch == '#' || ch == ':')
        return true;
    return false;
}

bool isBandSymbol(char ch)
{
    if (ch == '(' || ch == ')' || ch == ',' || ch == ';' || ch == '.')
        return true;
    return false;
}

int isStayWord(char *str)
{
    int i;
    for (i = 0; i < 13; ++i)
    {
        //printf("%s + !!\n",stayWord[i]);
        if (!strcmp(str, stayWord[i]))
            break;
    }
    return i;
}

void getInputStreamFromFile(char *fileName, char *str)
{
    char ch;
    int k = 0;
    FILE *f;
    f = fopen(fileName, "r");
    while ((ch = fgetc(f)) != EOF)
    {
        if (ch != '\n')
            str[k++] = ch;
        else
            str[k++] = ' ';
    }
    str[k] = '\0';
    fclose(f);
}

void calulationString(char *str)
{
    int len = strlen(str);
    int i;
    for (i = 0; i < len; ++i)
    {
        if (str[i] == '+')
            printf("  +  运算符/加号\n");
        else if (str[i] == '-')
            printf("  -  运算符/减号\n");
        else if (str[i] == '*')
            printf("  *  运算符/乘号\n");
        else if (str[i] == '/')
            printf("  /  运算符/除号\n");
        else if (str[i] == '=')
            printf("  =  运算符/等号\n");
        else if (str[i] == ':')
        {
            if (i + 1 < len && str[i + 1] == '=')
            {
                printf("  :=  运算符/赋值号\n");
                i++;
            }
            else
                printf("  %c  非法字符！\n", str[i]);
        }
        else if (str[i] == '#')
            printf("  #  运算符/不等于号\n");
        else if (str[i] == '>')
        {
            if (i + 1 < len && str[i + 1] == '=')
            {
                printf("  >=  逻辑运算符/大于等于号\n");
                i++;
            }
            else
                printf("  >  逻辑运算符/大于号\n");
        }
        else if (str[i] == '<')
        {
            if (i + 1 < len && str[i + 1] == '=')
            {
                printf("  <=  逻辑运算符/小于等于号\n");
                i++;
            }
            else
                printf("  <  逻辑运算符/小于号\n");
            ;
        }
    }
}

void bandString(char *str)
{
    int len, i;
    len = strlen(str);
    for (i = 0; i < len; ++i)
        switch (str[i])
        {

        case '(':
            printf("  (  界符/左括号\n");
            break;
        case ')':
            printf("  )  界符/右括号\n");
            break;
        case ',':
            printf("  ,  界符/逗号\n");
            break;
        case ';':
            printf("  ;  界符/分号\n");
            break;
        case '.':
            printf("  .  界符/结束号\n");
            break;
        default:
            break;
        }
}
void Analysis(char *InputFileName, char *str)
{
    getInputStreamFromFile(InputFileName, str);
    int len = strlen(str);
    int i, j, len1, len2, k, t, re;
    char str1[100], str2[100];
    i = 0;
    while (i < len)
    {
        j = 0;
        while (str[i] == ' ' && i < len)
            ++i;
        while (str[i] != ' ' && i < len)
            str1[j++] = str[i++];
        str1[j] = '\0';
        len1 = strlen(str1);
        k = 0;
        while (k < len1)
        {
            if (isCase(str1[k]))
            {
                t = 0;
                while ((!isCaculationSymbol(str1[k])) && (!isBandSymbol(str1[k])) && k < len1)
                    str2[t++] = str1[k++];
                str2[t] = '\0';
                re = isStayWord(str2);
                if (re < 13)
                {
                    printf("  %s  基本字/%s\n", stayWord[re], enumStayWord[re]);
                    strcpy(str2, "");
                    t = 0;
                }
                else
                {
                    printf("  %s  标识符\n", str2);
                    strcpy(str2, "");
                    t = 0;
                }
            }
            else if (isNumber(str1[k]))
            {
                while (isNumber(str1[k]) && k < len1)
                    str2[t++] = str1[k++];
                str2[t] = '\0';
                printf("  %s  常数\n", str2);
                strcpy(str2, "");
                t = 0;
            }
            else if (isCaculationSymbol(str1[k]))
            {
                while (isCaculationSymbol(str1[k]) && k < len1)
                    str2[t++] = str1[k++];
                str2[t] = '\0';
                calulationString(str2);
                strcpy(str2, "");
                t = 0;
            }
            else if (isBandSymbol(str1[k]))
            {
                while (isBandSymbol(str1[k]) && k < len1)
                    str2[t++] = str1[k++];
                ;
                str2[t] = '\0';
                bandString(str2);
                strcpy(str2, "");
                t = 0;
            }
            else
            {
                printf("  字符串无法识别！\n");
                k++;
            }
        }
        strcpy(str2, "");
    }
    fclose(stdout);
}