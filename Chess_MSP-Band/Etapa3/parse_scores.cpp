#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
#include <map>
#include <iterator>
#include <vector>
#include <fstream>

#include "constants.h"

#define INPUT "late.in"

#define TABLE 64
#define SPECIES 12
#define ROWS 8
#define COLUMNS 8
#define BUFLEN 150

using namespace std;

void feed_squares(map<int,string>& squares);

int main() {

    char buf[150];
    bzero(buf,BUFLEN);

    map<int,string> squares;
    map<int, vector<int>> scores;
    vector<int> v[64];

    for (int i = 0; i < TABLE; i++) {
        scores.insert({i,v[i]});
    }

    for (int i = 0; i < 64; i++) {
        auto a = scores.at(i);
    }

    feed_squares(squares);

    string line;
    ifstream file(INPUT);
    if (file.is_open()) {

        for (int i = 0; i < SPECIES; i++) {
            for (int j = 0; j < ROWS; j++) {
                
                bzero(buf,BUFLEN);
                getline(file, line);
                strcpy(buf, line.c_str());

                int a = atoi(strtok(buf, "\t"));
                int b = atoi(strtok(NULL, "\t"));
                int c = atoi(strtok(NULL, "\t"));
                int d = atoi(strtok(NULL, "\t"));
                int e = atoi(strtok(NULL, "\t"));
                int f = atoi(strtok(NULL, "\t"));
                int g = atoi(strtok(NULL, "\t"));
                int h = atoi(strtok(NULL, "\t"));

                scores.at(COLUMNS * j + 0).push_back(a);
                scores.at(COLUMNS * j + 1).push_back(b);
                scores.at(COLUMNS * j + 2).push_back(c);
                scores.at(COLUMNS * j + 3).push_back(d);
                scores.at(COLUMNS * j + 4).push_back(e);
                scores.at(COLUMNS * j + 5).push_back(f);
                scores.at(COLUMNS * j + 6).push_back(g);
                scores.at(COLUMNS * j + 7).push_back(h);

            }
            getline(file, line);
        }

        file.close();
    }

    int columnIndex = 0;
    for (int i = 0; i < TABLE; i++) {
        cout << "lateValueMap.put(Constants." << squares.at(i) << ", new StorageValue( ";
        
        /*for (auto it = scores.at(i).begin(); it != scores.at(i).end(); ++it){
            cout << *it << ", ";
        }*/
        int j = 0;
        auto it = scores.at(i).begin();
        for(it = scores.at(i).begin(); j < SPECIES-1; ++it){
            cout << *it << ", ";
            j++;
        }
        cout << *it;

        cout << " ));";
        cout << endl;
        columnIndex += 1;
        if(columnIndex % 8 == 0){
            cout << endl;   
        }
    }


    return 0;
}


void feed_squares(map<int,string>& squares){

    squares.insert({A1, "A1"});
    squares.insert({A2, "A2"});
    squares.insert({A3, "A3"});
    squares.insert({A4, "A4"});
    squares.insert({A5, "A5"});
    squares.insert({A6, "A6"});
    squares.insert({A7, "A7"});
    squares.insert({A8, "A8"});

    squares.insert({B1, "B1"});
    squares.insert({B2, "B2"});
    squares.insert({B3, "B3"});
    squares.insert({B4, "B4"});
    squares.insert({B5, "B5"});
    squares.insert({B6, "B6"});
    squares.insert({B7, "B7"});
    squares.insert({B8, "B8"});

    squares.insert({C1, "C1"});
    squares.insert({C2, "C2"});
    squares.insert({C3, "C3"});
    squares.insert({C4, "C4"});
    squares.insert({C5, "C5"});
    squares.insert({C6, "C6"});
    squares.insert({C7, "C7"});
    squares.insert({C8, "C8"});

    squares.insert({D1, "D1"});
    squares.insert({D2, "D2"});
    squares.insert({D3, "D3"});
    squares.insert({D4, "D4"});
    squares.insert({D5, "D5"});
    squares.insert({D6, "D6"});
    squares.insert({D7, "D7"});
    squares.insert({D8, "D8"});

    squares.insert({E1, "E1"});
    squares.insert({E2, "E2"});
    squares.insert({E3, "E3"});
    squares.insert({E4, "E4"});
    squares.insert({E5, "E5"});
    squares.insert({E6, "E6"});
    squares.insert({E7, "E7"});
    squares.insert({E8, "E8"});

    squares.insert({F1, "F1"});
    squares.insert({F2, "F2"});
    squares.insert({F3, "F3"});
    squares.insert({F4, "F4"});
    squares.insert({F5, "F5"});
    squares.insert({F6, "F6"});
    squares.insert({F7, "F7"});
    squares.insert({F8, "F8"});

    squares.insert({G1, "G1"});
    squares.insert({G2, "G2"});
    squares.insert({G3, "G3"});
    squares.insert({G4, "G4"});
    squares.insert({G5, "G5"});
    squares.insert({G6, "G6"});
    squares.insert({G7, "G7"});
    squares.insert({G8, "G8"});

    squares.insert({H1, "H1"});
    squares.insert({H2, "H2"});
    squares.insert({H3, "H3"});
    squares.insert({H4, "H4"});
    squares.insert({H5, "H5"});
    squares.insert({H6, "H6"});
    squares.insert({H7, "H7"});
    squares.insert({H8, "H8"});

}