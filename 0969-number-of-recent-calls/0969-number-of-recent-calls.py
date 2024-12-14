class RecentCounter(object):
    def __init__(self):
        # Initialize an empty list to hold timestamps of requests.
        self.requests = []

    def ping(self, t):
        """
        :type t: int
        :rtype: int
        """
        # Add the current request's timestamp to the list.
        self.requests.append(t)
        
        # Remove all timestamps that are older than t - 3000.
        while self.requests[0] < t - 3000:
            self.requests.pop(0)
        
        # Return the count of requests that are within the time range [t - 3000, t].
        return len(self.requests)
