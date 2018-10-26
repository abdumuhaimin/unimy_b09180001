#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char string[30];
    printf("Please input your string to be observed: ");
    fgets(string,30,stdin);

    char alphabet;
    printf("Enter the alphabets to be determined: ");
    scanf("%c",&alphabet);

    int max = strlen(string);
    int counter = 0;

    int i;
    for(i=0;i<max;i++){
        if(string[i] != 'i')
            continue;
        counter++;
    }

    printf("Your string is: %s\nThere's %d %c's in the string.",string,counter,alphabet);
}
