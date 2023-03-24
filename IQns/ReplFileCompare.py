import json

def isValid(stale, latest, operations):
    ops_list = json.loads(operations)
    cursor = 0
    for operation in ops_list:
        if(operation['op']=="insert"):
            stale = stale[:cursor] + operation["chars"] + stale[cursor:]
            cursor+=len(operation["chars"])
        else:
            if(cursor + operation['count'] > len(stale)):
                return False
            if(operation['op']=="skip"):
                cursor += operation['count']
            else:
                stale = stale[:cursor]+stale[cursor + operation["count"]:]
    if(stale==latest):
        return True
    return False


print(isValid(
  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
  'Repl.it uses operational transformations.',
  '[{"op": "skip", "count": 40}, {"op": "delete", "count": 47}]'
))#true

print(isValid(
  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
  'Repl.it uses operational transformations.',
  '[{"op": "skip", "count": 45}, {"op": "delete", "count": 47}]'
)) #false, delete past end

print(isValid(
  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
  'Repl.it uses operational transformations.',
  '[{"op": "skip", "count": 40}, {"op": "delete", "count": 47}, {"op": "skip", "count": 2}]'
))# false, skip past end

print(isValid(
  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
  'We use operational transformations to keep everyone in a multiplayer repl in sync.',
  '[{"op": "delete", "count": 7}, {"op": "insert", "chars": "We"}, {"op": "skip", "count": 4}, {"op": "delete", "count": 1}]'
))# true
  
print(isValid(
  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
  'We can use operational transformations to keep everyone in a multiplayer repl in sync.',
  '[{"op": "delete", "count": 7}, {"op": "insert", "chars": "We"}, {"op": "skip", "count": 4}, {"op": "delete", "count": 1}]'
))#false

print(isValid(
  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
  'Repl.it uses operational transformations to keep everyone in a multiplayer repl in sync.',
  '[]'
)) #true
