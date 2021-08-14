/**
 * Date: 2021. 08. 14.
 * Author: inhyuck | https://github.com/inhyuck
 * Solution URL: https://github.com/inhyuck/algorithm
 * Title: 완주하지 못한 선수
 * description: 전체 선수와 완주한 선수가 주어지고 완주하지 못한 선수 구하기.
 * Problem URL: https://programmers.co.kr/learn/courses/30/lessons/42576
 */

function solution(participant, completion) {
    const participantMap = {};
    participant.forEach(name => {
        if (participantMap[name]) {
            participantMap[name] += 1;
            return;
        }
        participantMap[name] = 1;
    });

    completion.forEach(name => {
        participantMap[name] -= 1;
    });

    return Object.keys(participantMap)
                 .find(name => participantMap[name] > 0);
}

//input
const participant = ['marina', 'josipa', 'nikola', 'vinko', 'filipa'];
const completion = ['josipa', 'filipa', 'marina', 'nikola'];

const result = 'vinko';

//output
console.log(solution(participant, completion));
console.log(result === solution(participant, completion));
